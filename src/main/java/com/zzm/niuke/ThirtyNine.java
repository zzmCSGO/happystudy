package com.zzm.niuke;

import com.zzm.structure.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.niuke
 * @Author: zzm
 * @CreateTime: 2024-03-18  11:44
 * @Description: TODO
 * @Version: 1.0
 */
public class ThirtyNine {

    public static void main(String[] args) {
        ThirtyNine thirtyNine = new ThirtyNine();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left1 = new TreeNode(4);
        TreeNode right1 = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = right1;
        String s = thirtyNine.Serialize(root);
        System.out.println(s);
        TreeNode node = thirtyNine.Deserialize(s);
        System.out.println(node);
    }

    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs1(root, sb);
        return sb.toString();


    }


    TreeNode Deserialize(String str) {
        String[] arr = str.split(",");
        LinkedList<String> queue = new LinkedList<>();
        for (String s : arr) {
            queue.offer(s);
        }
        TreeNode node= dfs2(queue);
        return node;
    }



    public void dfs1(TreeNode node, StringBuilder sb) {
        //先序遍历
        if (node == null) {
            //遍历到空
            sb.append("null").append(",");
            return;
        }
        sb.append(node.val).append(",");
        dfs1(node.left, sb);
        dfs1(node.right, sb);
    }
    //1,2,4,null,null,5,null,null,3,null,null,
    //    1
    //  2   3
    //4   5
    public TreeNode dfs2(LinkedList<String> queue){
           if(queue.isEmpty()){
                return null;
            }
            String s=queue.poll();
            if(s.equals("null")){
                return null;
            }
            TreeNode node=new TreeNode(Integer.parseInt(s));
            node.left=dfs2(queue);
            node.right=dfs2(queue);
            return node;
    }


}
