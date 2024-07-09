package com.zzm.structure.binarytree;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.structure.binarytree
 * @Author: zzm
 * @CreateTime: 2024-01-18  11:42
 * @Description: TODO
 * @Version: 1.0
 */
//树节点类
public class TreeNode {

    public int val;
    public TreeNode left;

    public TreeNode right;


    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode( TreeNode left,int val, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;

    }

    @Override
    public String toString() {
        return String.valueOf(this.val);
    }
}
