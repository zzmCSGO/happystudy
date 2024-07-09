package com.zzm.hot100.hundred;

import com.zzm.structure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-18  12:24
 * @Description: TODO
 * @Version: 1.0
 */
//二叉树的中序遍历
public class NinetyFour {
    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        inOrder(root,list);
        return list;

    }

    public void inOrder(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        inOrder(node.left,list);
        list.add(node.val);
        inOrder(node.right,list);
    }
}
