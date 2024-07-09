package com.zzm.hot200.ten;

import com.zzm.structure.binarytree.TreeNode;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200
 * @Author: zzm
 * @CreateTime: 2024-01-18  15:39
 * @Description: TODO
 * @Version: 1.0
 */
//101.对称二叉树
public class One {

    public static void main(String[] args) {

        //[1,2,2,3,4,4,3]
        TreeNode root=new TreeNode(
                new TreeNode(new TreeNode(3),2,new TreeNode(4)),
                1,
                new TreeNode(new TreeNode(4),2,new TreeNode(3))
        );
        System.out.println(isSymmetric(root));

    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }

    private static boolean check(TreeNode left, TreeNode right) {
        if(left==null&& right==null){
            return true;
        }
        //left和right不能同时为null
        if(left==null || right==null){
            return false;
        }
        if(left.val!=right.val){
            return false;
        }
        return check(left.left,right.right) && check(left.right,right.left);
    }
}
