package com.zzm.hot200.ten;

import com.zzm.structure.binarytree.TreeNode;

import java.util.*;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200.ten
 * @Author: zzm
 * @CreateTime: 2024-01-26  16:35
 * @Description: TODO
 * @Version: 1.0
 */
//108：二叉树的层序遍历II
public class Seven {
    public static void main(String[] args) {

        TreeNode node=new TreeNode(new TreeNode(2),4,new TreeNode(new TreeNode(1),3,new TreeNode(5)));
//        TreeNode node=new TreeNode(0);
        System.out.println(levelOrderBottom(node).toString());

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        TreeNode node=root;
        Queue<TreeNode> queue=new ArrayDeque<>() ;
        LinkedList<List<Integer>> stack=new LinkedList<>();//用来存放每一层节点的栈
        queue.offer(node);
        while(!queue.isEmpty()){
            int size= queue.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp=queue.poll();
                list.add(temp.val);
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
            stack.push(list);
        }
        List<List<Integer>> res=new ArrayList<>();
        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
        return res;
    }
}
