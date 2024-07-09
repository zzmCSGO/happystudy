package com.zzm.juc.syn;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;

/**
 * @BelongsProject: happystudy
 * @BelongsPackage: com.zzm.juc.syn
 * @Author: zzm
 * @CreateTime: 2024-03-22  13:50
 * @Description: TODO
 * @Version: 1.0
 */
@Slf4j(topic = "c.TestMyBiased")
public class TestMyBiased {

    static Thread t1,t2,t3;
    static Pig pig=new Pig();
    public static void main(String[] args) {
        log.debug("对象初始状态");
        log.debug(ClassLayout.parseInstance(pig).toPrintable());
        t1=new Thread(()->{
            log.debug("线程1开始执行，先输出一下头信息");
            log.debug(t1.getName()+ClassLayout.parseInstance(pig).toPrintable());
            synchronized (pig){
                for(int i=0;i<100;i++){
                    System.out.print(" ");
                }
                log.debug(t1.getName()+ClassLayout.parseInstance(pig).toPrintable());
            }
        },"t1");

        t2=new Thread(()->{
            log.debug("线程2开始执行，先输出一下头信息");
            log.debug(t2.getName()+ClassLayout.parseInstance(pig).toPrintable());
            synchronized (pig){
                for(int i=0;i<200;i++){
                    System.out.print(" ");
                }
                log.debug(t2.getName()+ClassLayout.parseInstance(pig).toPrintable());
            }
        },"t2");
        t1.start();
        t2.start();
    }
}

class Pig {

}
