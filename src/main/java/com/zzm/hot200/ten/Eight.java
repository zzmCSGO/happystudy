package com.zzm.hot200.ten;

import com.zzm.structure.binarytree.TreeNode;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200.ten
 * @Author: zzm
 * @CreateTime: 2024-01-27  12:59
 * @Description: TODO
 * @Version: 1.0
 */
//108.将有序数组转换为二叉搜索树
public class Eight {
    public static void main(String[] args) {

    }
//    BST 的中序遍历是升序的，因此本题等同于根据中序遍历的序列恢复二叉搜索树。
//    因此我们可以以升序序列中的任一个元素作为根节点，以该元素左边的升序序列构建左子树，以该元素右边的升序序列构建右子树，
//    这样得到的树就是一棵二叉搜索树啦～ 又因为本题要求高度平衡，因此我们需要选择升序序列的中间元素作为根节点奥


    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public static TreeNode dfs(int[] nums,int left,int right){
        if(left>right){
            return null;
        }
        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);

        root.left=dfs(nums,left,mid-1);
        root.right=dfs(nums,mid+1,right);
        return root;
    }

}
