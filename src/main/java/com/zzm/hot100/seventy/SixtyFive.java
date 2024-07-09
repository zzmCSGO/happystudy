package com.zzm.hot100.seventy;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.seventy
 * @Author: zzm
 * @CreateTime: 2024-02-21  15:28
 * @Description: TODO
 * @Version: 1.0
 */
public class SixtyFive {
    public boolean isNumber(String s) {
        boolean isNum = false, isDecimal = false, isE = false,isSign = false;
        int len = s.length() - 1;
        for (int i = 0; i <= len; i++) {
            char tmp = s.charAt(i);
            if (0 <= tmp - '0' && tmp - '0' <= 9) {
                isNum = true;
            } else if (tmp == '.'){
                if (isDecimal || (!isNum && i == len) || isE)
                    return false;
                isDecimal = true;
            } else if (tmp == 'e' || tmp == 'E') {
                if (isE || !isNum || i == len)
                    return false;
                isE = true;
            } else if (tmp == '-' || tmp == '+' ) {
                if ((i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') || i == len)
                    return false;
                isSign = true;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
