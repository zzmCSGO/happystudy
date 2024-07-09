package com.zzm.hot100.eighty;

import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100.eighty
 * @Author: zzm
 * @CreateTime: 2024-02-22  14:00
 * @Description: TODO
 * @Version: 1.0
 */
public class SeventyOne {

    public static void main(String[] args) {
        SeventyOne seventyOne = new SeventyOne();
        String s = seventyOne.simplifyPath("/../");
        System.out.println(s);
    }

    public String simplifyPath(String path) {
        String[] s = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        for (String s1 : s) {
            if (s1.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!s1.equals("") && !s1.equals(".")) {
                stack.push(s1);// foo home
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append("/").append(stack.pollLast());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }

}
