package com.zzm.hot100.eighty;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.eighty
 * @Author: zzm
 * @CreateTime: 2024-02-22  14:43
 * @Description: TODO
 * @Version: 1.0
 */
//74.搜索二维矩阵
public class SeventyFour {
    public static void main(String[] args) {
        SeventyFour seventyFour = new SeventyFour();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        boolean b = seventyFour.searchMatrix(matrix, 3);
        System.out.println(b);
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][n - 1]) {
                int[] arr = matrix[i];
                int left = 0;
                int right = n - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (arr[mid] > target) {
                        right = mid - 1;
                    } else if (arr[mid] < target) {
                        left = mid + 1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
