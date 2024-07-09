package com.zzm.hot100.ten;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-12  12:52
 * @Description: TODO
 * @Version: 1.0
 */
//正则表达式匹配
public class Ten {
    public static void main(String[] args) {
        String s="abeccc";
        String p="abecc*";
        System.out.println(new Ten().isMatch(s,p));
    }


    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }



    public boolean isMatch2(String s, String p) {

        int s_index=s.length()-1;
        int p_index=p.length()-1;
        return dfs(s,p,s_index,p_index);
    }


    public boolean dfs(String s,String p,int i,int j){
        //0是首个数组字母,递归出口
        if(i<0 && j<0){
            return true; //都匹配完了
        }

        //p比s长
        if(i<0){
            //s:abc p:bbabc   s:abc p:***abc
            //当s被匹配完时，判断当前p是否为 ‘*’,是的话往左边移动j,否则就是p冗余了，返回false
            return p.charAt(j)=='*' ? dfs(s,p,i,j-2) : false;
        }
        //p比s短
        if(j<0) {
            //当p用完了，但s还有，直接false
            return false;
        }

        if(p.charAt(j) == '*'){
            //p:.* s:ab    i:acbbc
            //看看p[j-1]是否为'.',是的话可以匹配，否则判断s[i]和p[j-1]是否相同
            if(p.charAt(j-1)=='.' || p.charAt(j-1) == s.charAt(i)){
                //*表示可以匹配前面的字符，也可以不匹配
                //当可以匹配时，我们也可以选择不匹配，所以有两个分支
                return dfs(s,p,i,j-2) || dfs(s,p,i-1,j);
            }else{
                //j:abec* i abe true
                return dfs(s,p,i,j-2);//无法匹配直接false
            }
        }else if(p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)){ //s[i]==p[j]
            return dfs(s,p,i-1,j-1);
        }else{
            //s[i] != p[j]
            return false;
        }

    }



}
