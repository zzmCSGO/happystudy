package com.zzm.hot100.hundred;

import com.zzm.structure.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-21  17:06
 * @Description: TODO
 * @Version: 1.0
 */
//98. 验证二叉搜索树的正确性
public class NinetyEight {
    public static void main(String[] args) {

    }

    //可以利用二叉搜索树的中序遍历是有序的特性
    public boolean noRecIsValidBST(TreeNode root) {
        TreeNode node=root;
        LinkedList<TreeNode> stack=new LinkedList<>();
        long prev=Long.MIN_VALUE;
        while(node!=null||!stack.isEmpty()){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else{
                TreeNode pop=stack.pop();
                //处理值
                if(prev>=pop.val){
                    return false;
                }
                prev=pop.val;
                node=pop.right;
            }
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return doValid(new AtomicLong(Long.MIN_VALUE),root);
    }

    public boolean doValid(AtomicLong prev, TreeNode node) {
        if (node == null) {
            return true;
        }
        boolean a = doValid(prev, node.left);
        if (prev.get() >= node.val) {
            return false;
        }
        prev.set(node.val);
        boolean b = doValid(prev, node.right);
        return a && b;
    }
}
