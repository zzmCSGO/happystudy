package com.zzm.hot900;

import com.zzm.structure.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot900
 * @Author: zzm
 * @CreateTime: 2024-01-21  17:45
 * @Description: TODO
 * @Version: 1.0
 */
//938. 二叉搜索树的范围和
public class ThirtyEight {
    public static void main(String[] args) {

    }

    public int noRecRangeSumBST(TreeNode root, int low, int high) {
        TreeNode node = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        int sum = 0;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                TreeNode pop = stack.pop();
                if (pop.val > high) {
                    break;
                }
                if (pop.val >= low && pop.val <= high) {
                    //处理值
                    sum += pop.val;
                }
                node = pop.right;
            }
        }
        return sum;
    }


    public int rangeSumBST(TreeNode node, int low, int high) {
        if (node == null) {
            return 0;
        }
        if (node.val < low) {
            return rangeSumBST(node.right, low, high);
        }
        if (node.val > high) {
            return rangeSumBST(node.left, low, high);
        }

        return node.val +
                rangeSumBST(node.left, low, high) +
                rangeSumBST(node.right, low, high);
    }

}
