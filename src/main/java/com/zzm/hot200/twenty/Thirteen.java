package com.zzm.hot200.twenty;

import com.zzm.structure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author:zzm
 * @Date:2024/8/23 20:01
 */
public class Thirteen {

    public static void main(String[] args) {
        //todo aaa
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        List<List<Integer>> res = pathSum(root, targetSum);
    }
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> stack = new LinkedList<>();
        backtrack(root, targetSum, stack, res);
        return res;
    }

    public static void backtrack(TreeNode root, int targetSum, LinkedList<Integer> stack, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        //叶子节点
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                stack.push(root.val);
//                stack.forEach(System.out::println);
                ArrayList<Integer> integers = new ArrayList<>(stack);
//                integers.forEach(System.out::println);
                res.add(integers);
                stack.pop();
            }
            return;
        }
        stack.push(root.val);
        backtrack(root.left, targetSum - root.val, stack, res);
        backtrack(root.right, targetSum - root.val, stack, res);
        stack.pop();
    }
}
