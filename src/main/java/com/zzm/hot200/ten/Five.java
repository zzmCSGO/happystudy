package com.zzm.hot200.ten;

import com.zzm.structure.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot200
 * @Author: zzm
 * @CreateTime: 2024-01-20  20:57
 * @Description: TODO
 * @Version: 1.0
 */
//105. 从前序与中序遍历序列构造二叉树
public class Five {
    public static void main(String[] args) {

    }

    //输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    //输出: [3,9,20,null,null,15,7]

    //根据前序遍历能判断出根节点   3   9    20 15 17
    //根据中序遍历能判断出左右子树   左:9   右:15,20,7
    //分清左右子树之后，对于左树右树又是一个遍历问题，所以可以递归解决
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //长度判断留一个也是没问题
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        int rootValue=preorder[0];
        //创建根节点
        TreeNode root=new TreeNode(rootValue);
        //区分左右子树
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i]==rootValue){
                //左子树 从0到i-1
                int[] inLeft = Arrays.copyOfRange(inorder, 0, i);//含头不含尾
                //右子树 从i+1到最后
                int[] inRight = Arrays.copyOfRange(inorder, i + 1, inorder.length);

                int[] preLeft = Arrays.copyOfRange(preorder, 1, i + 1);//拷贝的长度和inorder左子树一样
                int[] preRight = Arrays.copyOfRange(preorder, i + 1, preorder.length);//拷贝的长度和inorder右子树一样
                //递归
                root.left = buildTree(preLeft, inLeft); //9
                root.right = buildTree(preRight,inRight); //20
                //找到了就不用再找了,找到i就退出for循环
                break;
            }
        }

        return root;

    }
}
