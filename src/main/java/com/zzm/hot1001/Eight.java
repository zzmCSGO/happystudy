package com.zzm.hot1001;

import com.zzm.structure.binarytree.TreeNode;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot1001
 * @Author: zzm
 * @CreateTime: 2024-01-21  17:54
 * @Description: TODO
 * @Version: 1.0
 */
//1008. 前序遍历构造二叉搜索树
public class Eight {
    public static void main(String[] args) {

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root=new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {
            int val=preorder[i];
            insert(root,val);
        }
        return root;
    }

    public TreeNode insert(TreeNode root,int val){
        if(root==null){
            return new TreeNode(val);
        }
        if(root.val<val){
            root.right=insert(root.right,val);
        } else if (root.val>val) {
            root.left=insert(root.left,val);
        }
        return root;
    }

}
