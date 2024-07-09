package com.zzm.hot100.sixty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.sixty
 * @Author: zzm
 * @CreateTime: 2024-02-19  23:25
 * @Description: TODO
 * @Version: 1.0
 */
//56.合并区间
public class FiftySix {
    public static void main(String[] args) {
        FiftySix fiftySix = new FiftySix();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = fiftySix.merge(intervals);
        System.out.println(merge);
    }

        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][2];
            }
            //二维数组按照区间起始位置排序
            Arrays.sort(intervals, new Comparator<int[]>() {
                public int compare(int[] interval1, int[] interval2) {
                    return interval1[0] - interval2[0];
                }
            });
            List<int[]> merged = new ArrayList<int[]>();
            for (int i = 0; i < intervals.length; ++i) {
                //第i个区间的：L：左边界，R：右边界
                int L = intervals[i][0], R = intervals[i][1];
                //merged为空或者merged最后一个区间的右边界小于L
                if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                    merged.add(new int[]{L, R});
                } else {
                    //merged最后一个区间的右边界大于等于L，合并区间：merged最后一个区间的右边界更新为R和merged最后一个区间的右边界的最大值
                    merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
                }
            }
            return merged.toArray(new int[merged.size()][]);
        }


}
