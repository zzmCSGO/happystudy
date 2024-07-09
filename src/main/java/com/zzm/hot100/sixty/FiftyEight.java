package com.zzm.hot100.sixty;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.sixty
 * @Author: zzm
 * @CreateTime: 2024-02-20  12:50
 * @Description: TODO
 * @Version: 1.0
 */
public class FiftyEight {
    public int lengthOfLastWord(String s) {
        String[] res=s.split(" ");
        return res[res.length-1].length();
    }
}
