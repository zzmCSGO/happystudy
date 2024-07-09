package com.zzm.hot200.twenty;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200.twenty
 * @Author: zzm
 * @CreateTime: 2024-01-26  13:43
 * @Description: TODO
 * @Version: 1.0
 */
//118. 杨辉三角
public class Eighteen {
    public static void main(String[] args) {
        System.out.println(new Eighteen().generate(3).toString());
    }

    public List<List<Integer>> generate(int numRows) {
        int [] row=new int[numRows];
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> tempList=new ArrayList<>();
            createRow(row,i);
            for(int j=0;j<=i;j++){
                tempList.add(row[j]);
            }
            res.add(tempList);
        }
        return res;
    }

    public void createRow(int[] row,int i){
        if(i==0){
            row[0]=1;
            return;
        }
        for(int j=i;j>0;j--){
            row[j]=row[j]+row[j-1];
        }
    }


    public static int element(int i,int j){
        if(j==0||i==j){
            return 1;
        }
        //i为行，j为列，索引从0开始
        return element(i-1,j-1)+element(i-1,j);
    }

    //打印斜着的杨辉三角
    public static void print(int n){
        for (int i = 0; i < n; i++) {
            printSpace(n,i);
            for (int j = 0; j <=i; j++) {
                System.out.printf("%-4d",element(i,j));
            }
            System.out.println();
        }
    }

    //打印空格
    public static void printSpace(int n,int i){
        int num=(n-1-i)*2;
        for (int j = 0; j < num; j++) {
            System.out.print(" ");
        }
    }

    public static void printPlus(int n){
        int [] [] triangle=new int[n][];
        for (int i = 0; i < n; i++) {
            triangle[i]=new int[i+1];//第i行有i+1列
//            printSpace(n,i);
            for (int j = 0; j <=i; j++) {
                System.out.printf("%-4d",element(i,j));
            }
            System.out.println();
        }
    }

    //时间优化，使用二维数组保存已经计算过的值
    public static int elementPlus(int [] [] triangle,int i,int j){
        //递归判断，如果已经计算过，直接返回
        if(triangle[i][j]!=0){
            return triangle[i][j];
        }

        if(j==0||i==j){
            triangle[i][j]=1;
            return 1;
        }
        //i为行，j为列，索引从0开始
        triangle[i][j]=elementPlus(triangle,i-1,j-1)+elementPlus(triangle,i-1,j);
        return triangle[i][j];
    }

    //时间空间优化，使用一维数组保存已经计算过的值
    public static void creatRow(int [] row,int i){
        if(i==0){
            row[0]=1;
            return;
        }
        for (int j= i; j >0; j--) {
            row[j]=row[j]+row[j-1];
        }
    }

    public static void printPlusPlus(int n){
        int [] row=new int[n];
        for (int i = 0; i < n; i++) {
            creatRow(row,i);
//            printSpace(n,i);
            for (int j = 0; j <=i; j++) {
                System.out.printf("%-4d",row[j]);
            }
            System.out.println();
        }
    }
}
