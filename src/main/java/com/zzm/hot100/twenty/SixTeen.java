package com.zzm.hot100.twenty;

import java.util.*;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-14  14:12
 * @Description: TODO
 * @Version: 1.0
 */
//最接近的三数之和
public class SixTeen {
    public static void main(String[] args) {


        int target=1;
        int [] nums={-1,2,1,-4};
//        long start = System.currentTimeMillis();
//        System.out.println(threeSumClosest(nums,target));
//        long spend = System.currentTimeMillis()-start;
//        System.out.println("执行时间"+spend);
        System.out.println(plus(nums,target));
    }

    //超出时间限制
    public static int threeSumClosest(int[] nums, int target) {
        HashMap<String,Integer> map=new HashMap<>();
        map.put("abs",Integer.MAX_VALUE);
        //不重复指数据下标不重复
        int length=nums.length;
        int res=0;
        for(int i=0;i<length;i++){
            //i=0,j=1,k=2
            for(int j=0;j<length;j++){
                //遍历不重复下标的第二个
                if(i!=j){
                    for(int k=0;k<length;k++){
                        //先当成两数之和
                        if(k!=j&&k!=i){
                            int sum=nums[k]+nums[j]+nums[i];
                            //获得sum-target的绝对值
                            int abs=Math.abs(sum-target);
                            //如果这次的绝对值比上次的小，就更新res，记录新的sum
                            if(map.get("abs")>abs){
                                map.put("res",sum);
                                map.put("abs",abs);
                            }
                        }
                    }
                }
            }
        }
        res=map.get("res");
        //去重
        return res;
    }

    public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int length=nums.length;

        int res=nums[0]+nums[1]+nums[2];
        for(int i=0;i<length;i++){
            int left=i+1;
            int right=length-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(Math.abs(sum-target)<Math.abs(res-target)){
                    res=sum;
                }
                if(sum>target){
                    right--;
                }else if(sum<target){
                    left++;
                }else{
                    return res;
                }
            }
        }
        return res;
    }

    public int threeSumClosestRight(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i=0;i<nums.length;i++) {
            int start = i+1, end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    //ans记录的是最接近的三数之和
                    ans = sum;
                if(sum > target)
                    end--;
                else if(sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }


    public static int plus(int[] nums,int target){
        LinkedList<Integer> stack=new LinkedList<>();
        int result=0;
        int right=nums.length-1;
        int left=0;
        Arrays.sort(nums);
        dfs(3,nums,target,stack,left,right,result,0);
        return result;
    }

    public static void dfs(int n,int[] nums,int target,LinkedList<Integer> stack,int left,int right,int result,int temp){

        if(n==2){
            //两数之和
            twoSum(nums,target,left,right,temp,result);
            return ;
        }

        for(int i=left;i<right;i++){
            //去重
            if(i>left&&nums[i]==nums[i-1]){
                continue;
            }
            temp=nums[i];
            stack.push(nums[i]);
            dfs(n-1,nums,target,stack,left+1,right,result,temp);
            stack.pop();
        }
    }
    public static int twoSum(int[] nums,int target,int left,int right,int stack,int result){

        int abs=Integer.MAX_VALUE;
        while (left<right){
            int sum=nums[left]+nums[right]+stack;
            //如果这次的绝对值比上次的小，就更新abs，记录新的sum
            if(abs>Math.abs(sum-target)){
                result=sum;
                abs=Math.abs(sum-target);
            }
            //因为已经排好序了，只移动left只会让和变大，只移动right只会让和变小
            left++;
            right--;
            //去重
            while (left<right&&nums[left]==nums[left-1]){
                left++;
            }
        }
        return result;
    }
}
