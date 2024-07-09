package com.zzm.hot100.twenty;

import java.util.*;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-14  11:21
 * @Description: TODO
 * @Version: 1.0
 */

//三数之和
public class Fifteen {
    public static void main(String[] args) {

        int [] nums={1,0,-1,0,-2,2};
;
//        List<Integer> list=new ArrayList<>();
//        System.out.println(list);
        System.out.println(plus(nums));

    }

    //超时方法，但是可行
    public List<List<Integer>> threeSum(int[] nums) {

        HashMap<Integer,Integer> map=new HashMap();
        List<List<Integer>> list=new ArrayList<>();
        //不重复指数据下标不重复
        //选出的对应下面的三个数字相加为0
        int length=nums.length;
        for(int i=0;i<length;i++){
            //遍历的第一个数字nums[i]
            //变成两数之和的问题
            for(int j=0;j<length;j++){
                //遍历不重复下标的第二个
                if(i!=j){
                    map.put(j,nums[j]);
                    for(int k=0;k<length;k++){
                        //先当成两数之和
                        if(k!=j&&k!=i){
                            if(nums[k]+nums[j]+nums[i]==0){
                                //找到了
                                List<Integer> arr=new ArrayList<>();
                                arr.add(nums[i]);
                                arr.add(nums[j]);
                                arr.add(nums[k]);
                                //将arr这整个数组放入list中
                                list.add(arr);
                            }
                        }
                    }
                }
            }
        }
        //去重
        HashSet<List<Integer>> set=new HashSet<>();
        //将list中的每个数组中的元素进行排序
        list.forEach(item->{
            //item://[1, 0, -1]
            item.sort((o1, o2) -> o1-o2);
            set.add(item);
        });
        //将set中的元素放入list中
        list.clear();
        list.addAll(set);
        if(list.size()==0){
            return new ArrayList<>();
        }
        return list;

    }

    public static List<List<Integer>> plus(int[] nums) {
        //数组排序
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        LinkedList<Integer> stack=new LinkedList<>();
        int right=nums.length-1;
        int left=0;

        dfs(4,left,right,0,nums,stack,result);
        return result;
    }

    //n代表数字的个数，固定一个数字让n-1,什么时候n变为2了，就是两数之和的问题了
    static void dfs(int n,int i,int j,int target,int [] nums,LinkedList<Integer> stack,List<List<Integer>> result){

        if(n==2){
            //两数之和
            twoSum(i,j,nums,target,stack,result);
            return ;

        }
        for (int k = i; k <j-(n-2) ; k++) { //k代表固定的数字，四数之和可以i<j-2,三数之和可以i<j-1
            //检查左边界是否重复,防止越界，第一个数字不用检查重复
            if(k>i&&nums[k]==nums[k-1]){
                //当前数字等于上一个数字，跳过该数字，尝试下一个数字
                continue;
            }
            //固定一个数字，再尝试n-1数字之和
            stack.push(nums[k]);
            dfs(n-1,k+1,j,target-nums[k],nums,stack,result);
            //固定的数字遍历之后，弹出
            stack.pop();
        }

    }

    static public void twoSum(int i,int j,int[] nums, int target,LinkedList<Integer> stack,List<List<Integer>> result) {
        while(i<j){
            int sum=nums[i]+nums[j];
            if(sum<target){
                i++;
            }else if(sum>target){
                j--;
            }else{
                //找到解
                ArrayList<Integer> list = new ArrayList<>(stack);//固定的数字
                list.add(nums[i]);
                list.add(nums[j]);
                result.add(list);
                //继续查找其它的解，缩小范围
                i++;
                j--;
                while (i<j&&nums[i]==nums[i-1]){
                    i++;
                }
            }
        }
    }


    static public int[] twoSumDemo(int[] nums, int target) {
        //有序数组 nums
        int i=0;
        int j=nums.length-1;
        while(i<j){
            int sum=nums[i]+nums[j];
            if(sum<target){
                i++;
            }else if(sum>target){
                j--;
            }else{
                //找到解
                return new int[]{nums[i],nums[j]};
            }
        }
        return new int[]{};
    }

}
