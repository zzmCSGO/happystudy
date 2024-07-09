package com.zzm.hot100.sixty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.sixty
 * @Author: zzm
 * @CreateTime: 2024-02-20  13:19
 * @Description: TODO
 * @Version: 1.0
 */
//57. 插入区间
public class FiftySeven {
    public static void main(String[] args) {
        FiftySeven fiftySeven = new FiftySeven();
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int[][] insert = fiftySeven.insert(intervals, newInterval);
        System.out.println(insert);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length==0){
            return new int[][]{newInterval};
        }
        int[][] intervals2 = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            intervals2[i] = intervals[i];
        }
        intervals2[intervals.length] = newInterval;
        Arrays.sort(intervals2, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<int[]> res=new ArrayList<>();
        for(int i=0;i<intervals2.length;i++){
            int L=intervals2[i][0],R=intervals2[i][1];
            if(res.size()==0||res.get(res.size()-1)[1]<L){
                res.add(new int[]{L,R});
            }else{
                res.get(res.size()-1)[1]=Math.max(res.get(res.size()-1)[1],R);
            }

         }
        return res.toArray(new int[res.size()][]);
    }
}
