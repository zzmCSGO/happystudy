package com.zzm.hot100.fifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.fifty
 * @Author: zzm
 * @CreateTime: 2024-01-29  21:22
 * @Description: TODO
 * @Version: 1.0
 */

//49.字母异位词分组
public class FortyNine {
    public static void main(String[] args) {

    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            List<String> list = map.computeIfAbsent(key, k -> new ArrayList<>());
            //如果map里存在对应的key则取出，没有则创建。
            list.add(str);
        }
        return new ArrayList<>(map.values());
    }
}
