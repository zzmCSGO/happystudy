package com.zzm.hot100.seventy;

import java.util.Arrays;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.seventy
 * @Author: zzm
 * @CreateTime: 2024-02-20  13:54
 * @Description: TODO
 * @Version: 1.0
 */
//66.加一
public class SixtySix {
    public static void main(String[] args) {
        SixtySix sixtySix = new SixtySix();
        int[] ints = sixtySix.plusOne(new int[]{9,8,7,6,5,4,3,2,1,0});
        System.out.println(Arrays.toString(ints));
    }

        public int[] plusOne(int[] digits) {
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] = digits[i] % 10;
                if (digits[i] != 0) return digits;
            }
            digits = new int[digits.length + 1];
            digits[0] = 1;
            return digits;
        }

}
