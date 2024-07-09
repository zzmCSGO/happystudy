package com.zzm.hot100.sixty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.sixty
 * @Author: zzm
 * @CreateTime: 2024-02-18  21:12
 * @Description: TODO
 * @Version: 1.0
 */
//54.螺旋矩阵
public class FiftyFour {
    public List<Integer> spiralOrder(int[][] matrix) {

        if(matrix.length==0){
            return new ArrayList<Integer>();
        }
        int l=0,r=matrix[0].length-1,t=0,b=matrix.length-1,cur=0;
        Integer [] res=new Integer[(r+1)*(b+1)];
        while(true){
            for(int i=l;i<=r;i++){
                res[cur++]=matrix[t][i];
            }
            if(++t>b){
                break;
            }
            for(int i=t;i<=b;i++){
                res[cur++]=matrix[i][r];
            }
            if(--r<l){
                break;
            }
            for(int i=r;i>=l;i--){
                res[cur++]=matrix[b][i];
            }
            if(--b<t){
                break;
            }
            for(int i=b;i>=t;i--){
                res[cur++]=matrix[i][l];
            }
            if(++l>r){
                break;
            }
        }
        return Arrays.asList(res);
    }
}
