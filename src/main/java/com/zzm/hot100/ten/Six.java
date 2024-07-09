package com.zzm.hot100.ten;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-11  13:31
 * @Description: TODO
 * @Version: 1.0
 */
public class Six {

    public static void main(String[] args) {

        String name="123456";
        if(name.charAt(0) == '1'){
            //截取字符串name除了第一个字符以外的所有字符
            name = name.substring(1);
            //将字符串倒序输出
            StringBuffer stringBuffer = new StringBuffer(name);
            String reverse = stringBuffer.reverse().toString();
            //将字符串转换成int类型
            int i = Integer.parseInt(reverse);

        }
        char[] chars = name.toCharArray();


    }

    public String convert(String s, int numRows) {

        if(numRows < 2) return s;

        List<StringBuilder> rows = new ArrayList<StringBuilder>();

        //创建行数字符串构造器
        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        int i = 0, flag = -1;
        //第四轮循环的时候i进来时是3，flag变成-1，结束的时候-1,下次进来的时候是2
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1){
                flag = - flag;
            }
            //0的时候前进，3的时候倒退
            i += flag;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }
}
