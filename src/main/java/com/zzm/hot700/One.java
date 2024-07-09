package com.zzm.hot700;

import com.zzm.structure.binarytree.TreeNode;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot700
 * @Author: zzm
 * @CreateTime: 2024-01-21  16:56
 * @Description: TODO
 * @Version: 1.0
 */
//701. 二叉搜索树中的插入操作
public class One {
    public static void main(String[] args) {

    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            //找到空位置了
           return new TreeNode(val);
        }
        if(val<root.val){
            root.left=insertIntoBST(root.left,val);
        } else if (val>root.val) {
            root.right=insertIntoBST(root.right,val);
        }

        return root;
    }
}
