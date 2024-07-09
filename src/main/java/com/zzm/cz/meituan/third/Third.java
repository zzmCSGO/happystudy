package com.zzm.cz.meituan.third;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @BelongsProject: happystudy
 * @BelongsPackage: com.zzm.meituan.third
 * @Author: zzm
 * @CreateTime: 2024-03-23  10:33
 * @Description: TODO
 * @Version: 1.0
 */
public class Third {
    public static int maxSubstrings(long n, long k, String compressedStr) {
        // 解析压缩字符串
        Pattern pattern = Pattern.compile("([a-z])\\((\\d+)\\)");
        Matcher matcher = pattern.matcher(compressedStr);

        ArrayList<Long> counts = new ArrayList<>();
        long totalLength = 0;
        while (matcher.find()) {
            long count = Long.parseLong(matcher.group(2));
            counts.add(count);
            totalLength += count;
        }
        long uniqueChars = counts.size();

        // 如果整个字符串的权值小于k，则返回-1
        if (totalLength * uniqueChars < k) return -1;

        int substrCount = 0;
        long currLength = 0;
        int currUnique = 0;

        for (long count : counts) {
            currLength += count;
            currUnique++;
            // 当前子串的权值是否达到k
            if (currLength * currUnique >= k) {
                substrCount++;
                currLength = 0;
                currUnique = 0;
            }
        }

        return substrCount;
    }

    public static void main(String[] args) {
        long n =7;  // 原字符串长度
        long k = 6;  // 每个子串至少应有的权值
        String compressedStr = "a(2)b(2)a(3)";

        int result = maxSubstrings(n, k, compressedStr);
        System.out.println(result);
    }
}
