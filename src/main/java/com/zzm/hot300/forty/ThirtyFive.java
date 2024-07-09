package com.zzm.hot300.forty;

import com.zzm.structure.binarytree.TreeNode;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot300
 * @Author: zzm
 * @CreateTime: 2024-01-22  20:02
 * @Description: TODO
 * @Version: 1.0
 */
//235.求二叉搜索树最近公共祖先（祖先也包括自己）
public class ThirtyFive {
    public static void main(String[] args) {

    }

    //带查找的节点 pq,在某一结点的两侧，那么此节点就是最近的公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        TreeNode node=root;
        while(p.val<node.val && q.val<node.val || node.val<p.val && node.val<q.val){ //在一侧
            if(p.val<node.val ){
                node=node.left;
            }else {
                node=node.right;
            }
        }
        return node;

    }

}
