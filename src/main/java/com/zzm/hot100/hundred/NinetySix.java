//package com.zzm.hot100.hundred;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
///**
// * @BelongsProject: leet
// * @BelongsPackage: com.zzm.hot100
// * @Author: zzm
// * @CreateTime: 2024-01-23  20:57
// * @Description: TODO
// * @Version: 1.0
// */
////96.不同的二叉搜索树
//public class NinetySix {
//    public static void main(String[] args) {
//
//        String a="hello nowcoder";
//        String [] b = a.split(" ");
//        System.out.println(b[b.length-1].length());
//
//        List<Integer> c=List.of(1,2,3,4,5);
//        List<Integer> collect = c.stream().distinct().sorted().collect(Collectors.toList());
//
//    }
//
//    public int numTrees(int n) {
//        long c=1;
//        for (int i = 0; i < n; i++) {
//            c=c*2*(i*2+1)/(i+2);
//        }
//        return (int)c;
//
//    }
//}
