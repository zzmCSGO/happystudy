package com.zzm.hot100.twenty;

import java.util.*;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-14  20:29
 * @Description: TODO
 * @Version: 1.0
 */
//电话号码的字母组合
public class SevenTeen {
    public static void main(String[] args) {
            String s="23";
            System.out.println(letterCombinations(s).toString());

    }

    public List<String> letterCombinations2(String digits) {

        if(digits.equals("")){
            return new ArrayList();
        }
        int n=digits.length();
        LinkedList<String> stack=new LinkedList<>();
        List<String> result=new ArrayList<>();
        HashMap<String, ArrayList<Character>> map=new HashMap();
        map.put("2",new ArrayList<Character>(){{add('a');add('b');add('c');}});
        map.put("3",new ArrayList<Character>(){{add('d');add('e');add('f');}});
        map.put("4",new ArrayList<Character>(){{add('g');add('h');add('i');}});
        map.put("5",new ArrayList<Character>(){{add('j');add('k');add('l');}});
        map.put("6",new ArrayList<Character>(){{add('m');add('n');add('o');}});
        map.put("7",new ArrayList<Character>(){{add('p');add('q');add('r');add('s');}});
        map.put("8",new ArrayList<Character>(){{add('t');add('u');add('v');}});
        map.put("9",new ArrayList<Character>(){{add('w');add('x');add('y');add('z');}});
        dfs(n,digits,map,result,stack);
        return result;
    }

    public static void dfs(int n,String digits, HashMap<String, ArrayList<Character>> map, List<String> result,LinkedList<String> stack){
        if(n==2){
            two(digits,map,result);
            return;
        }
        int end=digits.length()-1;
        int start=0;
        while (end-start>2){
            stack.push(digits.substring(start,start+1));
            dfs(n-1,digits.substring(start+1,end),map,result,stack);//dfs3(3,"bcd“) dfs2(2,"cd")

            stack.pop();
        }
    }

    public static List<String> two(String digits, HashMap<String, ArrayList<Character>> map, List<String> result){
        String a=digits.substring(0,1);
        String b=digits.substring(1,2);
        List<Character> aList=map.get(a);
        List<Character> bList=map.get(b);
        for(int i=0;i<aList.size();i++){
            for(int j=0;j<bList.size();j++){
                StringBuilder sb=new StringBuilder();
                sb.append(aList.get(i));
                sb.append(bList.get(j));
                result.add(sb.toString());
            }
        }
        return result;
    }

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

}
