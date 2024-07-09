package com.zzm.hot300.fifty;

import java.util.Arrays;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot300.fifty
 * @Author: zzm
 * @CreateTime: 2024-01-29  21:53
 * @Description: TODO
 * @Version: 1.0
 */
public class FortyTwo {
    public boolean isAnagram(String s, String t) {
        char[] chars1 = s.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars2);
        //比较两个数组是否相等
        if(Arrays.equals(chars1,chars2)){
            return true;
        }else{
            return false;
        }
    }
}
