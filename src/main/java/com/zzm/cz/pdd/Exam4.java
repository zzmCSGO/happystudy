package com.zzm.cz.pdd;
import java.util.Scanner;


/**
 * @BelongsProject: happystudy
 * @BelongsPackage: com.zzm.cz.pdd
 * @Author: zzm
 * @CreateTime: 2024-03-24  20:06
 * @Description: TODO
 * @Version: 1.0
 */
public class Exam4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String s="tvuvv";
        int i = method2(s.toCharArray(), 0, s.length() - 1);
        System.out.println(i);
    }

    private static int method1(char[] cs, int begin, int end) {
        if (begin > end) {
            return 0;
        }
        int[] indexs = findSonString(cs, begin, end);
        int pre = begin;
        int sum = 1;
        for (int index : indexs) {
            sum += method1(cs, pre, index - 1);
            pre = index + 1;
        }
        if (pre < end) {
            sum += method1(cs, pre, end);
        }
        return sum;
    }

    private static int[] findSonString(char[] cs, int begin, int end) {
        if (begin > end) {
            return new int[0];
        }
        if (begin == end) {
            return new int[] {begin};

        }

        int[] res1 = new int[0];
        int[] res2 = null;
        int[] res3 = null;

        if (cs[begin] == cs[end]) {
            int[] son = null;
            son = findSonString(cs, begin + 1, end - 1);
            res1 = new int[son.length + 2];
            res1[0] = begin;
            res1[son.length + 1] = end;
            System.arraycopy(son, 0, res1, 1, son.length);

        }
        res2 = findSonString(cs, begin + 1, end);
        res3 = findSonString(cs, begin, end - 1);
        int len1 = res1.length;
        int len2 = res2.length;
        int len3 = res3.length;
        int res = Math.max(Math.max(len1, len2), len3);
        if (res == len1) {
            return res1;
        } else if (res == len2) {
            return res2;
        } else {
            return res3;
        }

    }
    //把下面method1,findSonString时间复杂度优化一下
    private static int method2(char[] cs, int begin, int end) {
        if (begin > end) {
            return 0;
        }
        int[] indexs = findSonString(cs, begin, end);
        int pre = begin;
        int sum = 1;
        for (int index : indexs) {
            sum += method1(cs, pre, index - 1);
            pre = index + 1;
        }
        if (pre < end) {
            sum += method1(cs, pre, end);
        }
        return sum;
    }








}
