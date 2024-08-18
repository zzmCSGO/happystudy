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
        //1,3,2,4
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


    static void morris(TreeNode root) {
        if (root == null) return;

       /* 我们在遍历过程中使用了 prev 变量来记录中序遍历的前一个节点。
        在每次访问当前节点 curr 的时候，通过比较 prev 和 curr 的值来识别不符合顺序的节点。
        如果 prev.val > curr.val，则 prev 和 curr 是不符合顺序的一对。
        如果 first 尚未被设置（即第一个不符合顺序的节点），则设为 prev。
        无论如何，second 设置为 curr。*/
        TreeNode curr = root;
        TreeNode prev = null;//记录上一个遍历的值
        TreeNode first = null;//记录第一个逆序值，之后不变，只更新second
        TreeNode second = null;//最后一个逆序位置

        while (curr != null) {
            if (curr.left == null) {
                // 检查 prev 和 curr 是否不符合顺序
                if (prev != null && prev.val > curr.val) {
                    if (first == null) {
                        first = prev;
                    }
                    second = curr;
                }
                prev = curr; //记录过后更新prev指针
                //curr变成下一个
                curr = curr.right;
            } else {
                // 找到当前节点左子树的最右节点（前驱节点）
                TreeNode pre = curr.left;
                while (pre.right != null && pre.right != curr) {
                    pre = pre.right;
                }

                if (pre.right == null) {
                    // 建立线索
                    pre.right = curr;
                    curr = curr.left;
                } else {
                    // 恢复树的结构
                    pre.right = null;
                    // 检查 prev 和 curr 是否不符合顺序
                    if (prev != null && prev.val > curr.val) {
                        //记录第一个逆序的位置，如果已经存在则不再修改了
                        if (first == null) {
                            first = prev;
                        }
                        second = curr;
                    }
                    //prev更新为当前值
                    prev = curr;
                    curr = curr.right;
                }
            }
        }

        // 交换 first 和 second 的值来修正树
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

}
