package com.zzm.hot400;

import com.zzm.structure.binarytree.TreeNode;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot400
 * @Author: zzm
 * @CreateTime: 2024-01-21  15:51
 * @Description: TODO
 * @Version: 1.0
 */
//450. 删除二叉搜索树中的节点
public class Fifty {
    public static void main(String[] args) {
        //root:[5,3,6,2,4,null,7]


    }

//    public TreeNode deleteNode(TreeNode root, int key) {
//        //首先要找到这个节点
//        TreeNode node=root;
//        TreeNode parent=null; //需要知道被删除节点的父节点
//        while(node!=null){
//            if(node.val>key){
//                //记录当前节点的父节点
//                parent=node;
//                node=node.left;
//            } else if (node.val<key) {
//                parent=node;
//                node=node.right;
//            }else{
//                //找到节点了
//                break;
//            }
//        }
//        //如果没有找到节点，返回null
//        if(node==null){
//            return null;
//        }
//        //找到该节点
//        //如果该节点没有左右子树
//        //如果该节点没有左子树，有右子树
//        if(node.left==null){
//            shift(parent,node,node.right,root);
//        }
//        //如果该节点没有右子树，有左子树
//        else if(node.right==null){
//            shift(parent,node,node.left,root);
//        }
//        //如果该节点左右子树都有
//        else{
//            //找到被删除节点的后继节点
//            TreeNode successor=node.right;
//            TreeNode successorParent=node;
//            while(successor.left!=null){
//                successorParent=successor;
//                successor=successor.left;
//            }
//            //处理后继节点
//            if(successorParent!=node){//如果后继节点不和删除节点相邻
//                shift(successorParent,successor,successor.right,root);
//                successor.right=node.right;
//            }
//            //后继节点取代被删除的节点
//            shift(parent,node,successor,root);
//            successor.left=node.left;
//        }
//        return node;
//    }
//
//    public void shift(TreeNode parent,TreeNode deleted,TreeNode child,TreeNode root){
//        if(parent==null){
//            //说明node是根节点
//            root=child;
//        }
//        if(parent.left==deleted){
//            parent.left=child;
//        }else{
//            parent.right=child;
//        }
//
//    }

    public TreeNode deleteNodeRight(TreeNode root,int key) {

        if(root==null){
            return null;
        }

        //与被删除节点的父亲建立左孩子或有孩子关系
        if(key<root.val){
            root.left=deleteNode(root.left,key);
            return root;
        }
        if(key>root.val){
            root.right=deleteNode(root.right,key);
            return root;
        }

        if(root.left==null){
            return root.right;
        }

        if(root.right==null){
            return root.left;
        }

        TreeNode s=root.right;//有两个孩子
        while(s.left!=null){
            s=s.left;
        }
        //处理后继节点
        s.right=deleteNode(root.right,s.val);
        s.left=root.left;
        return s;
    }
    public TreeNode deleteNode(TreeNode root,int key) {
    TreeNode p = root;
    TreeNode parent = null;
    while (p != null) {
        if (key < p.val) {
            parent = p;
            p = p.left;
        } else if (p.val < key) {
            parent = p;
            p = p.right;
        } else {
            break;
        }
    }
    if (p == null) {
        return null;
    }
    // 删除操作
    if (p.left == null) {
        shift(parent, p, p.right,root); // 情况1
    } else if (p.right == null) {
        shift(parent, p, p.left,root); // 情况2
    } else {
        // 情况4
        // 4.1 被删除节点找后继
        TreeNode s = p.right;
        TreeNode sParent = p; // 后继父亲
        while (s.left != null) {
            sParent = s;
            s = s.left;
        }
        // 4.2 删除和后继不相邻, 处理后继的后事
        if (sParent != p) {
            shift(sParent, s, s.right,root); // 不可能有左孩子
            s.right = p.right;
        }
        // 4.3 后继取代被删除节点
        shift(parent, p, s,root);
        s.left = p.left;
    }
    return p;
}

    private void shift(TreeNode parent, TreeNode deleted, TreeNode child,TreeNode root) {
        if (parent == null) {
            root = child;
        } else if (deleted == parent.left) {
            parent.left = child;
        } else {
            parent.right = child;
        }
    }
}


