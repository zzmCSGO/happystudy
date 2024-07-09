package com.zzm.e;

import com.zzm.structure.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.e
 * @Author: zzm
 * @CreateTime: 2024-01-20  20:43
 * @Description: TODO
 * @Version: 1.0
 */
//根据后缀表达式构造表达式树
public class E08ExpressionTree {
    public static void main(String[] args) {

    }
    /*
    中缀表达式           (2-1)*3
    后缀（逆波兰）表达式   21-3*

    1.遇到数字入栈
    2.遇到运算符, 出栈两次, 与当前节点建立父子关系, 当前节点入栈

    栈
    |   |
    |   |
    |   |
    _____

    表达式树
        *
       / \
      -   3
     / \
    2   1

    21-3*
 */

//    public static TreeNode buildTree(String[] tokens) {
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        for (String token : tokens) {
//            switch (token) {
//                case "+","-","/","*" ->{
//                    //先弹出来的是右孩子
//                    TreeNode right = stack.pop();
//                    TreeNode left = stack.pop();
//                    TreeNode parent = new TreeNode(Integer.parseInt(token));
//                    parent.left = left;
//                    parent.right = right;
//                    //用来和之后的数字进行比较
//                    stack.push(parent);
//                }
//                default->{
//                    stack.push(new TreeNode(Integer.parseInt(token)));
//                }
//
//            }
//        }
//        return stack.peek();
//    }

    //二叉树的后序遍历也能得到二叉树的后缀表达式
    public void postOrder(TreeNode node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);

    }
}
