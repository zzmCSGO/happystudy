package com.zzm.hot300.thirty;

import com.zzm.structure.binarytree.TreeNode;


/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot300
 * @Author: zzm
 * @CreateTime: 2024-01-20  20:33
 * @Description: TODO
 * @Version: 1.0
 */
//226.反转二叉树
public class TwentySix {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        fn(root);
        return  root;
    }


    public static void fn(TreeNode node){

        if(node==null){
            return ;
        }
        //交换一下左右节点
        TreeNode temp=node.left;
        node.left=node.right;
        node.right=temp;
        fn(node.left);
        fn(node.right);

    }


}
