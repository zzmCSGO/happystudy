package com.zzm.hot200.fifty;

import com.zzm.structure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200
 * @Author: zzm
 * @CreateTime: 2024-01-18  14:46
 * @Description: TODO
 * @Version: 1.0
 */
//144.二叉树非递归前序遍历
public class FortyFour {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        noRecOrder(root,res);
        return res;
    }

    public void noRecOrder(TreeNode root, List<Integer> list){
        //创建一个栈
        LinkedList<TreeNode> stack=new LinkedList<>();
        TreeNode pop=null;
        //记录当前节点
        TreeNode curr=root;
        while(curr!=null||!stack.isEmpty()){
            if(curr!=null){
                list.add(curr.val);
                //把当前节点放入栈中
                stack.push(curr);
                curr=curr.left;
            }else{
                TreeNode peek=stack.peek();
                if(peek.right==null){
                    pop=stack.pop();
                }else if(peek.right==pop){//右节点已经处理完事
                    pop=stack.pop();
                }else{
                    curr=peek.right;
                }
            }
        }

    }
}
