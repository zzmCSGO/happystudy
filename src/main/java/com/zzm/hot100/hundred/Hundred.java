package com.zzm.hot100.hundred;

import com.zzm.structure.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.hot100
 * @Author: zzm
 * @CreateTime: 2024-01-22  20:57
 * @Description: TODO
 * @Version: 1.0
 */
//100相同的树
public class Hundred {
    public static void main(String[] args) {
        //节点1,2,3
        TreeNode node1=new TreeNode(new TreeNode(2),1,new TreeNode(3));
        TreeNode node2=new TreeNode(new TreeNode(2),1,new TreeNode(3));
        System.out.println(new Hundred().isSameTree(node1,node2));

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<Integer> pList=new ArrayList<>();
        List<Integer> qList=new ArrayList<>();
        pList=getValue(p,pList);
        qList=getValue(q,qList);
        System.out.println(pList.toString());
        System.out.println(qList.toString());
        if(pList.hashCode()==qList.hashCode()){
            return true;
        }else{
            return  false;
        }

    }

    public List<Integer> getValue(TreeNode p, List<Integer> list){
        if(p==null){
            return null;
        }
        list.add(p.val);
        getValue(p.left,list);
        getValue(p.right,list);

        return list;
    }
}
