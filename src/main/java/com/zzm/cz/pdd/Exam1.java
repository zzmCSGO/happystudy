package com.zzm.cz.pdd;

/**
 * @BelongsProject: happystudy
 * @BelongsPackage: com.zzm.cz.pdd
 * @Author: zzm
 * @CreateTime: 2024-03-24  18:47
 * @Description: TODO
 * @Version: 1.0
 */
public class Exam1 {
    //有两个由0和1组成的字符串，A和B，长度分别为m和n(m>=n)。希望取出A的连续子串与B构造若干长度为n的S串，满足
//Si=Ax+i⊕Bi,  i∈[1,n], x∈[0,m-n]
//S1⊕S2⊕S3⊕...⊕Sn-1⊕Sn=0
    //⊕代表异或运算
    //想知道总共能够构造出多少个不同的S串

    public static void main(String[] args) {
        String A = "10100000";
        String B = "10";
        //符合条件的S串为["00","11"]，分别由A的子串["10","01"]与B串得到
        int i = maxSubstrings(A, B);
        System.out.println(i);
    }

    public static int maxSubstrings(String A, String B) {
        int res = 0;
        int m = A.length();
        int n = B.length();
        for (int i = 0; i <= m - n; i++) {
            String subA = A.substring(i, i + n);
            String subB = B;
            if (check(subA, subB)) {
                res++;
            }
        }
        return res;
    }

    private static boolean check(String subA, String subB) {
        int n = subA.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum ^= (subA.charAt(i) - '0') ^ (subB.charAt(i) - '0');
        }
        return sum == 0;
    }

}
