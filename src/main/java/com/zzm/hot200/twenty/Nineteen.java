package com.zzm.hot200.twenty;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200.twenty
 * @Author: zzm
 * @CreateTime: 2024-01-26  14:24
 * @Description: TODO
 * @Version: 1.0
 */
//119.杨辉三角 II
public class Nineteen {
    public static void main(String[] args) {
        System.out.println(new Nineteen().getRow(3).toString());
    }

    public List<Integer> getRow(int rowIndex) {
        int index=rowIndex+1;
        int [] row=new int[index];
        for(int i=0;i<index;i++){
            createRow(row,i);
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<index;i++){
            res.add(row[i]);
        }
        return res;
    }


    public static void createRow(int [] row,int i){
        if(i==0){
            row[0]=1;
            return;
        }
        for (int j=i;j>0;j--){
            row[j]=row[j]+row[j-1];
        }
    }
}
