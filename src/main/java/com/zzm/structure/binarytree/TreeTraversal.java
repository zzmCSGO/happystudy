package com.zzm.structure.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.structure.binarytree
 * @Author: zzm
 * @CreateTime: 2024-01-18  12:02
 * @Description: TODO
 * @Version: 1.0
 */
public class TreeTraversal {

    public static void main(String[] args) {
        TreeNode root=new TreeNode(
                new TreeNode(new TreeNode(4),2,null),
                1,
                new TreeNode(new TreeNode(5),3,new TreeNode(6))
        );
//        preOrder(root);
//        inOrder(root);

//        postOrder(root);
        nonRecOrder(root);
        System.out.println("==================================");

    }


    //前序遍历
    static void preOrder(TreeNode node){
        //如果传过来的节点是空，那么直接返回
        if(node==null){
            return;
        }
        //调用规则都一样，所以采用递归遍历即可
        System.out.println(node.val+"\t");//值
        preOrder(node.left);//左
        preOrder(node.right);//右
    }

    //中序遍历
    static void inOrder(TreeNode node){
        if(node==null){
            return;
        }
        inOrder(node.left);//先访问左子树
        System.out.println(node.val+"\t");//访问当前节点的值
        inOrder(node.right);//再访问右子树
    }

    //后序遍历
    static void postOrder(TreeNode node){
        if(node==null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val+"\t");
    }

    //非递归出发点：节点的遍历路径是一致的。
    //非递归前序，中序遍历
    public void nonRecPreInOrder(TreeNode root){
        //用栈结构来存储走过的节点,记住回来的路（父亲节点)
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode curr=root;//代表的是当前节点
        while(curr!=null||!stack.isEmpty()){
            if(curr!=null){
                System.out.println("去"+curr.val+"\t"); //前序遍历
                stack.push(curr);//压入栈，记录回来的路径
                curr=curr.left;
            }else{
                //如果当前节点为空，那么就弹出栈顶元素
                curr=stack.pop();
                System.out.println("回"+curr.val+"\t"); //中序遍历
                curr=curr.right;
            }
        }
    }

    //非递归后序遍历
    public static void nonRecPostOrder(TreeNode root){
        //用栈结构来存储走过的节点,记住回来的路（父亲节点)
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode curr=root;//代表的是当前节点
        TreeNode pop=null;//记录最近一次弹栈的元素
        while(curr!=null||!stack.isEmpty()){
            if(curr!=null){
//                System.out.println("去"+curr.val+"\t");
                stack.push(curr);//压入栈，记录回来的路径
                curr=curr.left;
            }else{
                TreeNode peek=stack.peek();//栈顶元素
                //peek.right==pop：代表的是右子树已经处理完成
                if(peek.right==null || peek.right==pop){
                    //右子树处理完成
                     pop=stack.pop();
                    System.out.println("回"+pop.val+"\t");
                }else{
                    curr=peek.right;
                }

            }
        }
    }

    //前序遍历：在待处理右子树之前进行打印，中序遍历：在左子树处理之后，右子树处理之前进行打印，右子树为空也需要打印。
    //后序遍历：在处理右子树之后进行打印。
    //非递归遍历模板代码，前中后
    public static void nonRecOrder(TreeNode root){
        //用栈结构来存储走过的节点,记住回来的路（父亲节点)
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode curr=root;//代表的是当前节点
        TreeNode pop=null;//记录最近一次弹栈的元素
        while(curr!=null||!stack.isEmpty()){
            if(curr!=null){
                //压入栈，记录回来的路径
                stack.push(curr);
                System.out.println("前"+curr.val+"\t");
                //待处理左子树
                curr=curr.left;
            }else{
                TreeNode peek=stack.peek();//栈顶元素
                if(peek.right==null){ //没有右子树
                    System.out.println("中"+peek.val+"\t");
                    pop=stack.pop();
                    System.out.println("后"+pop.val+"\t");
                }else if(peek.right==pop){//右子树处理完成
                    pop=stack.pop();
                    System.out.println("后"+pop.val+"\t");
                }else{//待处理右子树
                    System.out.println("中"+peek.val+"\t");
                    curr=peek.right;
                }

            }
        }
    }




}
