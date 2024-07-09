package com.zzm.hot600;

import com.zzm.structure.binarytree.TreeNode;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot600
 * @Author: zzm
 * @CreateTime: 2024-01-21  17:02
 * @Description: TODO
 * @Version: 1.0
 */
//700查询二叉搜索树中的值
public class Hundred {
    public static void main(String[] args) {

    }
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(root.val<val){
            return searchBST(root.right,val);
        } else if (root.val>val) {
            return searchBST(root.left,val);
        }else {
            return root;
        }

    }
}
