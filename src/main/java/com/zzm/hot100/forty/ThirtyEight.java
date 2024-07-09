package com.zzm.hot100.forty;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.forty
 * @Author: zzm
 * @CreateTime: 2024-02-11  23:37
 * @Description: TODO
 * @Version: 1.0
 */
//38.外观数列
public class ThirtyEight {
    public static void main(String[] args) {
        ThirtyEight thirtyEight = new ThirtyEight();
        System.out.println(thirtyEight.countAndSay(2));
    }
    public String countAndSay(int n) {
        String res = "1";
        for(int i = 1; i < n; i++) {
            res = generate(res);
        }
        return res;
    }

    public String generate(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);
            int count = 0;
            while(i < s.length() && s.charAt(i) == ch) {
                count++;
                i++;
            }
            sb.append(Integer.toString(count));
            sb.append(ch);
        }
        return sb.toString();

    }

}
