package com.zzm.structure.binarytree;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.structure.binarytree
 * @Author: zzm
 * @CreateTime: 2024-01-26  20:39
 * @Description: TODO
 * @Version: 1.0
 */
//AVL树
/*
   二叉搜索树在插入和删除的时候，节点可能失衡
   如果在插入和删除的时候通过旋转，始终让二叉搜索树保持平衡，撑为自平衡的二叉搜索树
   AVL是自平衡二叉搜索树的实现之一
 **/

public class AVLTree {
    static class AVLNode{
        int key;
        Object value;
        AVLNode left;
        AVLNode right;
        int height=1;//高度

        public AVLNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public AVLNode(int key) {
            this.key = key;
        }

        public AVLNode(int key, Object value, AVLNode left, AVLNode right, int height) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }

    //防止出现null的问题
    private int height(AVLNode node){
        return node==null?0:node.height;
    }

    //更新节点高度，（新增，删除，旋转）
    private void updateHeight(AVLNode node){
        //当前节点的高度等于左右子树的最大高度+1
        node.height=Integer.max(height(node.left),height(node.right))+1;
    }

    //平衡因子 balance factor = 一个节点的 左子树高度-右子树高度 差值没有超过一就是平衡的
    private int bf(AVLNode node){
//        bf = 0，1，-1 时，表示左右平衡
//        bf > 1 时，表示左边太高
//        bf < -1 时，表示右边太高
        return height(node.left)-height(node.right);
    }

    //右旋, 传入要旋转的节点，返回旋转后的新的根节点
    private AVLNode rightRotate(AVLNode red){
        //不用考虑yellow为null，左边比右边高了，左边肯定不能为空
        //1，2顺序不能换
        AVLNode yellow = red.left; //1
        //因为右孩子比父亲节点大，需要需要考虑换爹
        AVLNode green = yellow.right;//2
        //上位
        yellow.right=red;
        //换爹
        red.left=green;
        //更新高度,不能调换顺序，因为父节点的高度是依赖于子节点的高度的
        updateHeight(red);
        updateHeight(yellow);
        return yellow;
    }

    //左旋，传入的是要旋转的节点，返回旋转后的新的根节点
    private AVLNode leftRotate(AVLNode red){
        AVLNode yellow=red.right;
        AVLNode green=yellow.left;
        yellow.left=red;
        red.right=green;
        updateHeight(red);
        updateHeight(yellow);
        return yellow;
    }

    //左右旋,先左旋左子树，再右旋根节点
    private AVLNode leftRightRotate(AVLNode node){
        node.left=leftRotate(node.left);
        return rightRotate(node);
    }


    //右左旋转
    private AVLNode rightLeftRotate(AVLNode node){
        node.right=rightRotate(node.right);
        return leftRotate(node);
    }

    //检查节点是否失衡，重新平衡树
    private AVLNode balance(AVLNode node){
        if(node==null){
            return null;
        }
        int bf = bf(node);
        if(bf>1 && bf(node.left)>=0){ //LL,或者
            return rightRotate(node);
        }else if(bf>1 && bf(node.left)<0){ //LR
            return leftRightRotate(node);
        } else if (bf<-1 && bf(node.right)>0) { //RL
            return rightLeftRotate(node);
        } else if (bf<-1 && bf(node.right)<=0) { //RR
            return leftRotate(node);
        }
        return node;
    }

    AVLNode root;

    public void put(int key,Object value){
        root=doPut(root,key,value);

    }

    public AVLNode doPut(AVLNode node,int key,Object value){
        //1.找到空位，创建新节点
        if(node==null){
            return new AVLNode(key,value);
        }
        //2.key在树中已经存在了，更新
        if(key==node.key){
            node.value=value;
            return node;
        }
        //3.继续查找
        if(key<node.key){
            node.left=doPut(node.left,key,value);
        }else{
            node.right=doPut(node.right,key,value);
        }
        updateHeight(node);//递归回去的过程中一点一点更新的
        //返回平衡后的节点
        return balance(node);
    }

    public void remove(int key){
        root=doRemove(root,key);

    }

    private AVLNode doRemove(AVLNode node,int key){
        //1.如果node为空直接返回
        if(node==null){
            return null;
        }
        //2.没有找到key继续递归
        if(key<node.key){
            node.left=doRemove(node.left,key);
        }else if(key>node.key){
            node.right=doRemove(node.right,key);
        }else{
            //3.找到key，1）.没有孩子 2）只有一个孩子 3）有两个孩子
            if(node.left==null&&node.right==null) {
                //没有孩子，自己也没了，返回null
                return null;
            }else if(node.left==null) {
                node=node.right;
            }else if(node.right==null) {
                node=node.left;
            }else{
                //先找到后继节点
                AVLNode s=node.right;
                while(s.left!=null){
                    s=s.left;
                }
                //处理后继节点的后事
                s.right=doRemove(node.right,s.key);
                s.left=node.left;
                node=s;
            }
        }
        //4.更新高度
        updateHeight(node);
        //5.平衡
        return balance(node);
    }



}
