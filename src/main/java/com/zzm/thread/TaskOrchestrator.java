package com.zzm.thread;


import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.*;
import java.util.concurrent.*;

/**
 * 线程池任务编排器，用于执行任务图中的任务
 * @param <T> 上下文类型 重新equals方法
 */
public class TaskOrchestrator<T> {
    // 任务线程池和TTL上下文
    private final ExecutorService executorService;
    private final TransmittableThreadLocal<List<T>> context; // 使用TransmittableThreadLocal存储泛型数据
    private final Map<String, List<String>> dependencyGraph; // 任务依赖图
    private final Map<String, Boolean> taskStatus; // 任务状态
    private final CountDownLatch latch; // 计数器用于等待所有任务完成
    private final Map<String, List<T>> contextStatus; // 上下文状态

    // 构造函数，初始化线程池和TTL上下文
    public TaskOrchestrator(int threadPoolSize, int totalTasks) {
        this.executorService = TtlExecutors.getTtlExecutorService(Executors.newFixedThreadPool(threadPoolSize));
        this.context = new TransmittableThreadLocal<>();
        this.dependencyGraph = new ConcurrentHashMap<>();
        this.taskStatus = new ConcurrentHashMap<>();
        this.contextStatus = new ConcurrentHashMap<>();
        this.latch = new CountDownLatch(totalTasks); // 初始化计数器
    }

    public TransmittableThreadLocal<List<T>> getContext() {
        return context;
    }

    // 执行任务图中的任务
    public void executeTasks(Map<String, List<String>> taskGraph, Map<String, Runnable> tasks) {
        buildDependencyGraph(taskGraph);
        initializeTaskStatus(taskGraph);

        List<String> rootTasks = new ArrayList<>();

        // 找出所有的无依赖任务（根任务）
        for (String taskId : taskGraph.keySet()) {
            if (dependencyGraph.get(taskId).isEmpty()) {
                rootTasks.add(taskId);
            }
        }

        // 并行提交无依赖任务
        for (String taskId : rootTasks) {
            submitTask(taskId, taskGraph, tasks);
        }

        // 等待所有任务完成
        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            // 所有任务完成后关闭线程池
            shutdown();
        }
    }

    // 提交任务的方法，用于实际提交任务到线程池执行
    private void submitTask(String taskId, Map<String, List<String>> taskGraph, Map<String, Runnable> tasks) {
        executorService.submit(() -> {
            try {
                tasks.get(taskId).run();


                List<String> executableTasks = new ArrayList<>();
                // 更新任务状态
                synchronized (taskStatus) {
                    taskStatus.put(taskId, true);
                    for (String dependentTaskId : taskGraph.getOrDefault(taskId, Collections.emptyList())) {
                        if (canExecuteTask(dependentTaskId)) {
                            executableTasks.add(dependentTaskId);
                        } else {
                            // 暂存上下文
                            List<T> newContext = context.get();
                            List<T> existingContext = contextStatus.getOrDefault(dependentTaskId, new ArrayList<>());

                            // 使用Set进行去重
                            Set<T> contextSet = new HashSet<>(existingContext);
                            if (newContext != null) {
                                contextSet.addAll(newContext);
                            }

                            // 将Set转换回List
                            List<T> mergedContext = new ArrayList<>(contextSet);
                            contextStatus.put(dependentTaskId, mergedContext);
                        }
                    }
                }

                System.out.println("任务 " + taskId + " 完成：" + Thread.currentThread().getName());

                // 并行执行所有可以执行的任务
                for (String executableTaskId : executableTasks) {
                    // 合并上下文
                    synchronized (taskStatus) {
                        List<T> mergedContext = context.get() == null ? new ArrayList<>() : new ArrayList<>(context.get());

                        // 使用Set进行去重
                        Set<T> contextSet = new HashSet<>(mergedContext);
                        if (contextStatus.get(executableTaskId) != null) {
                            contextSet.addAll(contextStatus.get(executableTaskId));
                        }
                        // 将Set转换回List
                        mergedContext = new ArrayList<>(contextSet);
                        context.set(mergedContext);
                        submitTask(executableTaskId, taskGraph, tasks);
                    }
                }
            } catch (Exception e) {
                System.err.println("执行任务 " + taskId + " 时出错: " + e.getMessage());
                e.printStackTrace();
            } finally {
                // 每个任务完成后减少计数
                latch.countDown();
            }
        });
    }

    // 检查任务是否可以执行
    private boolean canExecuteTask(String taskId) {
        for (String dependency : dependencyGraph.get(taskId)) {
            if (!taskStatus.getOrDefault(dependency, false)) {
                return false;
            }
        }
        return true;
    }

    // 构建任务依赖图
    private void buildDependencyGraph(Map<String, List<String>> taskGraph) {
        for (String taskId : taskGraph.keySet()) {
            dependencyGraph.putIfAbsent(taskId, new ArrayList<>());
            for (String dependentTaskId : taskGraph.get(taskId)) {
                dependencyGraph.putIfAbsent(dependentTaskId, new ArrayList<>());
                dependencyGraph.get(dependentTaskId).add(taskId);
            }
        }
    }

    // 初始化任务状态
    private void initializeTaskStatus(Map<String, List<String>> taskGraph) {
        for (String taskId : taskGraph.keySet()) {
            taskStatus.put(taskId, false);
        }
    }

    // 关闭线程池
    private void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    System.err.println("线程池未终止");
                }
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    // 主函数用于测试
    public static void main(String[] args) {
        // 定义任务有向图
        Map<String, List<String>> taskGraph = new HashMap<>();
        taskGraph.put("A", Arrays.asList("B"));
        taskGraph.put("X", Arrays.asList("B"));
        taskGraph.put("B", Arrays.asList("C","E"));
        taskGraph.put("C", Arrays.asList("D"));
        taskGraph.put("D", Arrays.asList("F"));
        taskGraph.put("E", Arrays.asList("F"));

        // 创建任务编排器并启动任务
        TaskOrchestrator<Integer> orchestrator = new TaskOrchestrator<>(5, taskGraph.size());
        TransmittableThreadLocal<List<Integer>> threadLocal = orchestrator.getContext();
        Random random = new Random(); // 随机数生成器

        // 定义具体的任务实现
        Map<String, Runnable> tasks = new HashMap<>();
        tasks.put("X", () -> test("X", random, threadLocal));
        tasks.put("A", () -> test("A", random, threadLocal));
        tasks.put("B", () -> test("B", random, threadLocal));
        tasks.put("C", () -> test("C", random, threadLocal));
        tasks.put("D", () -> test("D", random, threadLocal));
        tasks.put("E", () -> test("E", random, threadLocal));
        tasks.put("F", () -> test("F", random, threadLocal));

        orchestrator.executeTasks(taskGraph, tasks);
    }

    private static void test(String name, Random random, TransmittableThreadLocal<List<Integer>> threadLocal) {
        List<Integer> integers = threadLocal.get();
        List<Integer> previousSum = new ArrayList<>();
        if (integers != null) {
            previousSum.addAll(integers);
        }
        int randomValue = random.nextInt(100);
        previousSum.add(randomValue);
        threadLocal.set(previousSum);
        try {
            Thread.sleep(1000);
            System.out.println("-----");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("任务 " + name + " 执行, 随机数: " + " + " + randomValue + " = " + previousSum);
    }
}

