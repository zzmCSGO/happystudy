package com.zzm.hot100.hundred;

import com.zzm.structure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-23  20:28
 * @Description: TODO
 * @Version: 1.0
 */
//95. 不同的二叉搜索树 II
public class NinetyFive {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
//        for (TreeNode generateTree : new NinetyFive().generateTrees(3)) {
//
//        }


    }
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1,n);

    }

    public List<TreeNode> generateTrees(int start,int end){
        List<TreeNode> allTrees=new LinkedList<>();
        if(start>end){
            allTrees.add(null);
            return allTrees;
        }

        for(int i=start;i<=end;i++){
            List<TreeNode> leftTrees=generateTrees(start,i-1);

            List<TreeNode> rightTrees=generateTrees(i+1,end);

            for(TreeNode left:leftTrees){
                for(TreeNode right: rightTrees){
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);

                }
            }
        }
        return allTrees;
    }


}
