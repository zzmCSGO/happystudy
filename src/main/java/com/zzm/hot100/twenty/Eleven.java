package com.zzm.hot100.twenty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-12  21:28
 * @Description: TODO
 * @Version: 1.0
 */
public class Eleven {
    public static void main(String[] args) {
        List<HashMap<Integer,Integer>> list=new ArrayList<>();
        int [] height={1,1};
        int res=new Eleven().maxArea(height);
        System.out.println(res);
    }

    //高效解法
    public int maxArea2(int[] height) {

            int left=0; int right=height.length-1;
            int res=0;

            //遍历
            while(right>left){
                res=height[right]>height[left]?
                        Math.max(res,(right-left)*height[left++]):
                        Math.max(res,(right-left)*height[right--]);
            }

            return res;

    }

    public int maxArea(int[] height) {
        int m=height.length;
        int res=0;
        for(int i=0;i<m;i++){
           for(int j=0;j<m;j++) {
               int area = 0;
               int length = j - i;
               int width = Math.min(height[i], height[j]);
               //area永远是正数
               area = length * width < 0 ? -length * width : length * width;
               res = Math.max(res, area);
           }
        }
        return res;
    }
}
