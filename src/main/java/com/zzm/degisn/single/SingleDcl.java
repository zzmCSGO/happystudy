package com.zzm.degisn.single;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.degisn.single
 * @Author: zzm
 * @CreateTime: 2024-02-23  15:38
 * @Description: TODO
 * @Version: 1.0
 */
//DCL懒汉单例
public class SingleDcl {
    private static volatile SingleDcl singleDcl=null;

    private SingleDcl(){}

    public static SingleDcl getInstance(){
        if(singleDcl==null){
            synchronized(SingleDcl.class){
                if(singleDcl==null){
                    singleDcl=new SingleDcl();
                }
            }
        }
        return singleDcl;
    }
}
