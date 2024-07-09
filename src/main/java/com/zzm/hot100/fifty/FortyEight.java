package com.zzm.hot100.fifty;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.fifty
 * @Author: zzm
 * @CreateTime: 2024-02-17  22:36
 * @Description: TODO
 * @Version: 1.0
 */
//48. 旋转图像
public class FortyEight {

    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        new FortyEight().rotate(matrix);
        System.out.println(matrix);
    }
    public void rotate(int[][] matrix) {
        List<List<Integer>> temp=new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            List<Integer> list=new ArrayList<>();
            for (int j = 0; j < matrix.length; j++) {
                list.add(matrix[i][j]);
            }
            temp.add(list);
        }

        for(int i=0;i<matrix.length;i++){
            List<Integer> list = temp.get(i);
            for(int j=0;j<matrix.length;j++){
                matrix[j][matrix.length-1-i]=list.get(j);
            }
        }
    }
}
