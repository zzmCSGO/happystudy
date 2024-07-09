package com.zzm.hot100.ten;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-11  14:33
 * @Description: TODO
 * @Version: 1.0
 */
public class Seven {
    public static void main(String[] args) {
       int x=1534236469;
        System.out.println(new Seven().reverse(x));
    }


    public int reverse(int x) {

        if(x==0){
            return x;
        }

        String s=String.valueOf(x);
        String first=s.substring(0,1);
        if(first.equals("-")){
            String snew=s.substring(1);
            StringBuffer buffer=new StringBuffer(snew);
            String sReverse=buffer.reverse().toString();
            //去掉前面所有的0，直到遇到非0的数字
            int count=0;
            //-0000211
            if(sReverse.substring(0,1).equals("0")){
                count=1;
                for(int i=0;i<sReverse.length();i++){
                    if(sReverse.substring(i+1,i+2).equals("0")){
                        count++;
                    }else {
                        break;
                    }
                }
             }
            sReverse=sReverse.substring(count);
            String sResult="-"+sReverse;
            //将字符串转换成long类型
            long result=Long.parseLong(sResult);
            //result超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0
            if(result>Math.pow(2,31)-1||result<-Math.pow(2,31)){
                return 0;
            }

            return Integer.parseInt(sResult);
            }else{
            StringBuffer buffer=new StringBuffer(s);
            String sReverse=buffer.reverse().toString();
            System.out.println(sReverse);
            int count=0;
            //0000211
            if(sReverse.substring(0,1).equals("0")){
                count=1;
                for(int i=0;i<sReverse.length();i++){
                    if(sReverse.substring(i+1,i+2).equals("0")){
                        count++;
                    }else {
                        break;
                    }
                }
            }

            sReverse=sReverse.substring(count);
            //将字符串转换成long类型
            long result=Long.parseLong(sReverse);
            //result超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0
            if(result>Math.pow(2,31)-1||result<-Math.pow(2,31)){
                return 0;
            }
            return Integer.parseInt(sReverse);
        }
    }


    public int reversePlus(int x) {
        int res = 0;

        while(x!=0) {
            //每次取末尾数字
            int tmp = x%10;
            //判断是否 大于 最大32位整数
            if (res>214748364 || (res==214748364 && tmp>7)) {
                return 0;
            }
            //判断是否 小于 最小32位整数
            if (res<-214748364 || (res==-214748364 && tmp<-8)) {
                return 0;
            }
            res = res*10 + tmp;
            x /= 10;
        }
        return res;
    }


}
