package com.zzm.hot100.forty;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.forty
 * @Author: zzm
 * @CreateTime: 2024-02-17  14:12
 * @Description: TODO
 * @Version: 1.0
 */
public class ThirtyFive {
    private static volatile ThirtyFive Singleton=null;

    private ThirtyFive() {
    }

    public static ThirtyFive getInstance(){
        if(Singleton==null){
            synchronized (ThirtyFive.class){
                if(Singleton==null){
                   Singleton=new ThirtyFive();
                }
            }
        }
        return Singleton;
    }
}
