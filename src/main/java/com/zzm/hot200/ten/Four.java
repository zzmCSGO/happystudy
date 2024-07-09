package com.zzm.hot200.ten;

import com.zzm.structure.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200
 * @Author: zzm
 * @CreateTime: 2024-01-18  16:14
 * @Description: TODO
 * @Version: 1.0
 */
//104.二叉树的最大深度
//二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
public class Four {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(3), 2, new TreeNode(4)),
                1,
                new TreeNode(new TreeNode(4), 2, new TreeNode(3))
        );
        System.out.println(queueMaxDepth(root));

    }
    //1.递归
    public static int maxDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //叶子节点，没有孩子
//        if(node.left==null && node.right==null){
//            return 1;
//        }

        //左子树的最大深度
        int d1 = maxDepth(node.left);
        int d2 = maxDepth(node.right);
        return Integer.max(d1, d2) + 1;

    }

    //2.非递归遍历
    public static int noRecMaxDepth(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pop = null;
        TreeNode cur = node;
        int res = Integer.MIN_VALUE;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                res = Integer.max(res, stack.size());
                cur = cur.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == pop) {
                    pop = stack.pop();
                } else if (peek.right == null) {
                    pop = stack.pop();
                } else {
                    cur = peek.right;
                }
            }


        }
        return res;
    }


    //3.层序遍历，层数即最大深度
    public static int queueMaxDepth(TreeNode node){

        if(node==null){
            return 0;
        }
        //队列，先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int depth=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i <size; i++) {
                TreeNode poll=queue.poll();
//                System.out.print(poll.val+"\t");
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }
//            System.out.println();
            depth++;
        }
        return depth;
    }


}
