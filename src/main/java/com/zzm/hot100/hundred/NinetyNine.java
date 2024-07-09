package com.zzm.hot100.hundred;

import com.zzm.structure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-23  20:56
 * @Description: TODO
 * @Version: 1.0
 */
//99.恢复二叉搜索树
public class NinetyNine {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(new TreeNode(null,3,new TreeNode(2)),1,null);
        recoverTree(root);


    }

    public static void recoverTree(TreeNode root) {
        List<Integer> list = inorder(root, new ArrayList<>());
        int [] swap = findTwoSwapped(list);
        //交换搜索二叉树等于这两个值的节点
        recoverRec(root,2,swap[0],swap[1]);
    }

    public static void recoverRec(TreeNode node,int count,int x,int y){
        if(node!=null){
            if(node.val==x||node.val==y){
                node.val=node.val==x?y:x;
                //只换两个值
                if(--count==0){
                    return;
                }
            }
            recoverRec(node.right,count,x,y);
            recoverRec(node.left,count,x,y);
        }
    }
    //中序遍历得到数组
    public static List<Integer> inorder(TreeNode root,List<Integer> list){
        if(root==null){
            return list;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
        return list;
    }

    public static int[] findTwoSwapped(List<Integer> nums) {
        int index1 = -1, index2 = -1;
        for (int i = 0; i < nums.size() - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                index2 = i + 1;
                if (index1 == -1) {
                    index1 = i;
                } else {
                    break;
                }
            }
        }
        int x = nums.get(index1), y = nums.get(index2);
        return new int[]{x, y};
    }

}
