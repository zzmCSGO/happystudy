//package com.zzm.hot900;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//import java.util.Set;
//
///**
// * @BelongsProject: leet
// * @BelongsPackage: com.zzm.hot900
// * @Author: zzm
// * @CreateTime: 2024-01-29  23:14
// * @Description: TODO
// * @Version: 1.0
// */
////819.出现次数最多的单词
//public class Nineteen {
//
//    public String mostCommonWord(String paragraph, String[] banned) {
//        //正则表达式截取匹配
//        String[] split = paragraph.toLowerCase().split("[^A-Za-z]+");
//        Set<String> set = Set.of(banned);
//        HashMap<String,Integer> map=new HashMap<>();
//        for(String key:split){
//            if(!set.contains(banned)){
//                map.compute(key,(k,v)->v==null?1:v+1);
//            }
//        }
//        Optional<Map.Entry<String, Integer>> max = map.entrySet().stream().max(Map.Entry.comparingByValue());
//        return max.map(Map.Entry::getKey).orElse(null);
//    }
//
//    public String mostCommonWord2(String paragraph, String[] banned) {
//        //正则表达式截取匹配
//        StringBuilder sb=new StringBuilder();
//        char[] chars = paragraph.toLowerCase().toCharArray();
//        Set<String> set = Set.of(banned);
//        HashMap<String,Integer> map=new HashMap<>();
//        for(char ch:chars){
//          if(ch>='a'&&ch<='z'){
//              sb.append(ch);
//         }else{
//                String key = sb.toString();
//                if(!set.contains(key)){
//                    map.compute(key,(k,v)->v==null?1:v+1);
//                }
////                sb=new StringBuilder();
//              sb.setLength(0);//不创建了，节省时间
//          }
//
//        }
//        //没有分隔符的情况
//        if(sb.length()>0){
//            String key = sb.toString();
//            if(!set.contains(key)){
//                map.compute(key,(k,v)->v==null?1:v+1);
//            }
//        }
//        Optional<Map.Entry<String, Integer>> max = map.entrySet().stream().max(Map.Entry.comparingByValue());
//        return max.map(Map.Entry::getKey).orElse(null);
//    }
//}
