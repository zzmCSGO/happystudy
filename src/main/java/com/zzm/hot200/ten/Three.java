package com.zzm.hot200.ten;

import com.zzm.structure.binarytree.TreeNode;

import java.util.*;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200
 * @Author: zzm
 * @CreateTime: 2024-01-24  11:20
 * @Description: TODO
 * @Version: 1.0
 */
//103.二叉树z字层序遍历,二叉树的锯齿形层序遍历
public class Three {
    public static void main(String[] args) {
        TreeNode node=new TreeNode(new TreeNode(2),4,new TreeNode(3));
        System.out.println(new Three().zigzagLevelOrder(node));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //二叉树的层序遍历，并且把每一层的元素保存在一个集合里面
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return new ArrayList<>();
        }
        Queue<TreeNode> queue=new ArrayDeque<>();
        TreeNode node=root;
        queue.offer(node);
        boolean flag=true;//奇数层
        while(!queue.isEmpty()){
            LinkedList<Integer> level=new LinkedList<>();
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode qNode=queue.poll();
                if(flag){
                    level.offerLast(qNode.val);
                }else{
                    level.offerFirst(qNode.val);
                }
                if(qNode.left!=null){
                    queue.offer(qNode.left);
                }
                if(qNode.right!=null){
                    queue.offer(qNode.right);
                }
            }
            flag=!flag;//遍历完当前层之后取反
            res.add(level);
        }
        return res;
    }

}
