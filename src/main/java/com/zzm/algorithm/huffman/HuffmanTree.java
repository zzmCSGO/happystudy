package com.zzm.algorithm.huffman;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.algorithm.huffman
 * @Author: zzm
 * @CreateTime: 2024-02-24  11:45
 * @Description: TODO
 * @Version: 1.0
 */
public class HuffmanTree {
    /*
    * 哈夫曼树 是一个满二叉树
    * 1.将统计了出现频率的字符放入优先级队列
    * 2.每次出队两个频率最低的元素，将他俩找个爹
    * 3.将爹重新放入队列,重复2,3步骤，直到队列中只剩一个元素
    * 4.当队列只剩一个元素的时候，huffman树构建完成
    */

    static class Node{
        Character ch; //字符
        int freq; //频次
        Node left;
        Node right;
        String code;//编码

        public Node(Character ch) {
            this.ch = ch;
        }

        public Node( int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }

        int freq() {
            return freq;
        }

        boolean isLeaf(){
            return left==null;
        }

        public String toString(){
            return "Node{"+
                    "ch="+ch+
                    ",freq="+freq+
                    "}";
        }

    }

    //先统计每个字符出现的频次

    String str; //原始字符串，编码时候会用到
    Map<Character,Node> map =new HashMap<>();//拿map统计字符串频次
    Node root;
    public HuffmanTree(String str){
        this.str=str;
        //功能1：统计频率
        char[] chars = str.toCharArray();
        for (char c:chars){
//            if(!map.containsKey(c)){
//                map.put(c,new Node(c));
//            }
//            Node node= map.get(c);
//            node.freq++;
            //如果c不存在，就创建一个新的节点放入集合。如果存在，就返回原来的(值)节点
            Node node = map.computeIfAbsent(c, Node::new);
            node.freq++;
        }
        //功能二：构造树
        PriorityQueue<Node> queue=new PriorityQueue<>(
                //自定义比较器，可以用节点的一个属性来做比较
                Comparator.comparingInt(Node::freq)
        );
        queue.addAll(map.values());
        while(queue.size()>=2){
            Node x= queue.poll();
            Node y= queue.poll();
            int freq=x.freq+y.freq;
            Node parent = new Node(freq, x, y);
            queue.add(parent);
        }
         root= queue.poll();
        //功能3：计算每个字符的编码。
        //对二叉树进行遍历，遍历叶子节点，根据来时的路给出编码
        int sum = dfs(root, new StringBuilder());
        for(Node node:map.values()){
            System.out.println(node+" "+node.code);
        }
        System.out.println("总共回占用bits:" +sum);
//        for (Node node:map.values()){
//            System.out.println(node);
//        }
    }

    private int dfs(Node node,StringBuilder sb){
        //功能四：统计占用的总共比特位
        int sum=0;
        //中序遍历
        if(node.isLeaf()){
            //找到编码
//            System.out.println(node+sb.toString());
            node.code=sb.toString();
            sum=node.freq*node.code.length();
        }else{
            //向下走的情况下：向左走编码加0，向右走编码加1.往回走的情况下，编码减去最后一位
            sum+=dfs(node.left,sb.append('0'));
            sum+=dfs(node.right,sb.append('1'));
        }
        //首次调用的时候没有字符
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
        return sum;
    }

    //编码
    public String encode(){
        char[] chars = str.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(char c:chars){
            sb.append(map.get(c).code);
        }
        return sb.toString();
    }

    //解码
    public String decode(String str){
        /*
            从根节点，寻找数字对应的字符
            1.如果是0，就向左走
            2.如果是1，就向右走
            如果没有走到头，没走一步数字的索引i++,
            走到头就可以找到解码字符，再将node重置为根节点
        */
        char[] chars=str.toCharArray();
        int i=0;
        StringBuilder sb=new StringBuilder();
        Node node=root;
        while(i<chars.length){
            if(!node.isLeaf()){//非叶子
                if(chars[i]=='0'){//向左走
                    node=node.left;
                }else if(chars[i]=='1'){//向右走
                    node=node.right;
                }
                i++;
            }
            if(node.isLeaf()){
                sb.append(node.ch);
                node=root;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        HuffmanTree A = new HuffmanTree("abcc");
        String encode = A.encode();
        System.out.println(encode);
        String decode = A.decode(encode);
        System.out.println(decode);
    }
}
