package com.zzm.cz.mihayou;

import java.util.Scanner;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.mihayou
 * @Author: zzm
 * @CreateTime: 2024-03-17  10:58
 * @Description: TODO
 * @Version: 1.0
 */
public class Exam1 {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        //n个怪物，第i个生命值位hi
        //黑塔e技能E点伤害
        //怪物生命值，首次，<=最大生命值50%,敌方还有怪物,生命>0m则黑塔自动释放，则追加一个次转圈圈，造成R点上海
        //如果一次攻击给多个敌人满足条件，则连续触发转圈圈，转圈圈耗尽，或敌人都死位置，转圈圈结束的之前，无法再次使用E技能
        int t=in.nextInt();//t组数据
        for(int k=0;k<t;k++){
            int n=in.nextInt();//怪物的数量
            long[] hp=new long[n];
            for(int i=0;i<n;i++){
                hp[i]=in.nextLong();
            }
            long e=in.nextLong();//E技能伤害
            long r=in.nextLong();//转圈圈伤害
            int cntE=0;//使用E技能次数
            int cntR=0;//使用转圈圈次数
            long[] hp2=new long[n];
            boolean flag=false;//是否有怪物还存活
            int count=0;//看hp小于50的怪物数量
            boolean[] flag2=new boolean[n];//看某个位置的怪兽是否已经触发了甜甜圈
            //第一次使用E伤害
//        for(int i=0;i<n;i++){
//            hp2[i]=hp[i]-e;
//            if (hp2[i]>0){
//                //有怪物存活
//                flag=true;
//            }
//        }
            while(true){
                for(int i=0;i<n;i++){
                    hp2[i]=hp[i]-e;
                    if (hp2[i]>0){
                        //有怪物存活
                        flag=true;
                    }
                }
                cntE++;
                //遍历一下每个怪物的血量，看是否有hp小于50%的
                if(flag){//如果还有怪物存活
                    for(int i=0;i<n;i++){
                        if(hp2[i]<=(hp[i]/2)&&!flag2[i]){
                            //说明生命值小于一半了
                            count++;//记录一下甜甜圈要触发的次数
                            //记录一下某个怪物是否已经触发
                            flag2[i]=true;
                        }
                    }
                    //记录一下每一波甜甜圈的伤害
                    long rS=r*count;
                    for (int i = 0; i < n; i++) {
                        hp2[i]=hp2[i]-rS;
                    }
                    cntR+=count;//记录一下使用甜甜圈的次数
                    count=0;//每次伤害完之后归零
                    flag=false;
                }else{
                    break;
                }
            }
            System.out.println(cntE+" "+cntR);
        }
    }
}
