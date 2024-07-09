package com.zzm.cz.meituan.first;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.meituan
 * @Author: zzm
 * @CreateTime: 2024-03-09  11:13
 * @Description: TODO
 * @Version: 1.0
 */
public class Exam3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int n;//矩阵大小
        n = in.nextInt();

        //矩阵
        int[][]matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = in.next();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(countP(matrix,i));
        }

    }

    private static int countP(int [][]matrix, int i) {
        int count = 0;
        HashMap<String, Boolean> map = new HashMap<>();
        for (int row = 0; row < matrix.length - i + 1; row++) {
            for (int col = 0; col < matrix[row].length - i + 1; col++) {
                int zeroCount = 0;
                int oneCount = 0;
                for (int r = row; r < row + i; r++) {
                    for (int c = col; c < col + i; c++) {
                        if (matrix[r][c] == 0) {
                            zeroCount++;
                        } else {
                            oneCount++;
                        }
                    }
                }
                if (zeroCount == oneCount && !map.containsKey(row + "-" + col)) {
                    count++;
                    map.put(row + "-" + col, true);
                }
            }
        }
        return count;

    }
}
