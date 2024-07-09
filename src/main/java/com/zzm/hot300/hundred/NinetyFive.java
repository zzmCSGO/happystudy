package com.zzm.hot300.hundred;

import java.util.PriorityQueue;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot300
 * @Author: zzm
 * @CreateTime: 2024-01-25  10:30
 * @Description: TODO
 * @Version: 1.0
 */
//295.数据流的中位数 //大小顶堆实现
public class NinetyFive {
    public static void main(String[] args) {

    }
    /**
     为了保证两边数据量的平衡
     <ul>
     两边数据一样时,加入左边
     两边数据不一样时,加入右边
     </ul>
     但是, 随便一个数能直接加入吗?

     加入左边前, 应该挑右边最小的加入
     加入右边前, 应该挑左边最大的加入
     </ul>
     */

    //创建一个大顶堆
    private PriorityQueue<Integer>  maxHeap=new PriorityQueue<>(10,(a,b)->b-a);
    //创建一个小顶堆
    private PriorityQueue<Integer> minHeap=new PriorityQueue<>(10,(a,b)->a-b);

    public void addNum(int num) {
        //如果两个堆大小相等，就把元素先加入大顶堆，但不是直接加
        if(maxHeap.size()==minHeap.size()){
            //需要先加入小顶堆，再从小顶堆弹出一个元素加入大顶堆
            minHeap.offer(num);
            Integer temp=minHeap.poll();
            maxHeap.offer(temp);
        }else{
            //如果两个堆大小不相等，就把元素先加入小顶堆，但不是直接加
            //需要先加入大顶堆，再从大顶堆弹出一个元素加入小顶堆
            maxHeap.offer(num);
            Integer temp=maxHeap.poll();
            minHeap.offer(temp);
        }
    }



    /**
     * <ul>
     *     <li>两边数据一致, 左右各取堆顶元素求平均</li>
     *     <li>左边多一个, 取左边元素</li>
     * </ul>
     */
    public double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (maxHeap.peek()+minHeap.peek())/2.0;//需要返回double类型
        }else{
            return maxHeap.peek();
        }

    }
}
