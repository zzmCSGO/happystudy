package com.zzm.hot200.twenty;

import com.zzm.structure.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200
 * @Author: zzm
 * @CreateTime: 2024-01-18  16:59
 * @Description: TODO
 * @Version: 1.0
 */
//111.二叉树的最小深度
public class Eleven {

 /*   最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
    说明：叶子节点是指没有子节点的节点。*/
    public static void main(String[] args) {

    }


    //递归
    public int minDepth(TreeNode node) {
        if(node==null){
            return 0;
        }
        int d1=minDepth(node.left);
        int d2=minDepth(node.right);
        //左右子树如果有为空的话就不应该计算进去了
        if(d2==0 || d1==0){
            return d1+d2+1;
        }
        return Integer.min(d1,d2)+1;
    }

    //层序遍历，遇到第一个叶子节点就返回
    public int queueMinDepth(TreeNode node) {

        if(node==null){
            return 0;
        }
        //队列，先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        int depth=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            depth++;
            for (int i = 0; i <size; i++) {
                TreeNode poll=queue.poll();
                if (poll.left==null && poll.right==null){
                    return depth+1;
                }
                if(poll.left!=null){
                    queue.offer(poll.left);
                }
                if(poll.right!=null){
                    queue.offer(poll.right);
                }
            }

        }
        return depth;
    }

}
