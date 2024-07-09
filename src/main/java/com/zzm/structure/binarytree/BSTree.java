package com.zzm.structure.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.structure.binarytree
 * @Author: zzm
 * @CreateTime: 2024-01-21  11:27
 * @Description: TODO
 * @Version: 1.0
 */
//二叉搜索树 Binary Search Tree
public class BSTree<K extends Comparable<K>,V> { //泛型上限，必须是Comparable的子类,是可以比较大小的

    BSTNode<K,V> root;//根节点

    static class BSTNode<K,V> {
        K key; // 若希望任意类型作为 key, 则后续可以将其设计为 Comparable 接口
        V value;
        BSTNode<K,V> left;
        BSTNode<K,V> right;

        public BSTNode(K key) {
            this.key = key;

        }

        public BSTNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public BSTNode(K key, V value, BSTNode<K,V> left, BSTNode<K,V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //获取关键字对应的值
    public V get(K key){
        return doGet(root,key);
    }

    //查找最小关键字对应的值
    public V min(){
        return doMin(root);
    }

    private V min(BSTNode<K,V> node){
        if(node==null){
            return null;
        }
        BSTNode<K,V> p=node;
        while(p!=null){
            p=p.left;
        }
        return p.value;
    }



    public V doMin(BSTNode<K,V> node){
        if (node==null){
            return null;
        }
        if(node.left==null){ //最小值的节点
            return node.value;
        }
        return doMin(node.left);
    }

    //与min同理，就先不写递归了
    public V max(){
        return  max(root);
    }

    //通用方法
    private V max(BSTNode<K,V> node){
        if(node==null){
            return null;
        }
        BSTNode<K,V> p=node;
        while(p!=null){
            p=p.right;
        }
        return p.value;

    }


    public void put(K key, V value){
        //key有就更新，没有就新增
        BSTNode<K,V> node=root;
        BSTNode<K,V> parent=null;
        while (node!=null){
            parent=node;//最后一次node更新的时候，parent还没来得及更新
            int result=key.compareTo(node.key);
            if(result<0){
                node=node.left;
            } else if (result>0) {
                node=node.right;
            }else{
                //找到key了
                node.value=value;
                return;
            }

        }
        //没有找到key，新增
        //parent父节点
        if(parent==null){
            //空树，当前的节点就是根节点
            root=new BSTNode<>(key,value);
            return;
        }
        if(key.compareTo(parent.key)<0) {//左孩子
            parent.left = new BSTNode<>(key, value);
        }else{
            parent.right=new BSTNode<>(key,value);
        }

    }

    //根据关键字查到后继节点
    public V successor(K key){
        BSTNode<K,V> node=root;
        //自左而来的祖先
        BSTNode<K,V> ancestorFromRight=null;
        while(node!=null){
            int result=key.compareTo(node.key);
            if(result<0){
                ancestorFromRight=node;
                node=node.left;
            }else if(result>0){
                node=node.right;
            }else{
                //找到了
                break;
            }
        }
        //没有找到本届点
        if(node==null){
            return null;
        }

        if(node.right!=null){
           return  min(node.right);
        }
        return ancestorFromRight!=null? ancestorFromRight.value : null;
    }

    //根据关键字查到前驱节点
    public V predecessor(K key){
        BSTNode<K,V> node=root;
        //自左而来的祖先
        BSTNode<K,V> ancestorFromLeft=null;
        while(node!=null){
            int result=key.compareTo(node.key);
            if(result<0){
                node=node.left;
            }else if(result>0){
                ancestorFromLeft=node;
                node=node.right;
            }else{
                //找到了
                break;
            }
        }
        //没有找到本届点
        if(node==null){
            return null;
        }
        /*
            1.节点有左子树，此时前驱节点就是左子树的最大值
            2.节点没有左子树，若离它最近的祖先自从左而来，此祖先即为前驱
         */
        //1.节点有左子树，此时前驱节点就是左子树的最大值
        if(node.left!=null){
            return max(node.left);
        }
        //2.节点没有左子树，若离它最近的祖先自从左而来，此祖先即为前驱
        return ancestorFromLeft!=null? ancestorFromLeft.value : null;

    }

    //删除关键字对应的值，只删除一个节点
    public V delete(K key){

        BSTNode<K,V> node=root;
        //记录待删除节点的父亲
        BSTNode<K,V> parent=null;
        while(node!=null){
            int result=key.compareTo(node.key);
            if(result<0){
                parent=node;
                node=node.left;
            }else if(result>0){
                parent=node;
                node=node.right;
            }else{
                //找到了
                break;
            }
        }
        //没找到
        if(node==null){
            return null;
        }

        //删除操作
        if(node.left==null){
            shift(parent,node,node.right);
        }else if(node.right==null){
            shift(parent,node,node.left);
        }else {
            //情况四
            //4.1找到被删除节点的后继节点
            BSTNode<K,V> s=node.right;
            BSTNode<K,V> sParent=node;
            while(s.left!=null){//找右子树最小值
                sParent=s;
                s=s.left;
            }
            //4.2处理后继节点的后事,后继节点即为s
            if(sParent!=node){//不相邻
                shift(sParent,s,s.right);//不可能再有左孩子了，因为最小值就是最后一个左孩子
                s.right=node.right;
            }
            //4.3后继节点取代掉被删除节点
            shift(parent,node,s);
            s.left=node.left;
        }
        return node.value;

    }

    //递归版本删除
    public V recDelete(K key){
        ArrayList<V> result=new ArrayList<>();
        root = doDelete(root, key,result);
        return result.isEmpty()?null:result.get(0);

    }

    //node是起点,返回值是剩下的孩子或null
    private BSTNode<K,V> doDelete(BSTNode<K,V> node,K key,ArrayList<V> res){
        if(node==null){
            return null;
        }
        int result=key.compareTo(node.key);
        if(result<0){
            node.left = doDelete(node.left, key,res);
            return node;
        }
        if(result>0){
            node.right=doDelete(node.right,key,res);
            return node;
        }
        res.add(node.value);
        //情况1-只有左孩子
        if(node.right==null){
            return node.left;
        }
        //情况2-只有右孩子
        if(node.left==null){
            return node.right;
        }
        //情况3-有两个孩子
        BSTNode<K,V> s=node.right;
        while(s.left!=null){
            s=s.left;
        }
        //删除那个节点并不是我们要找的返回值
        s.right=doDelete(node.right,s.key,new ArrayList<>());
        s.left=node.left;
        return s; //删剩下的再跟之前递归调用的时候建立父子关系就好了。
    }

    //托孤方法
    private void shift(BSTNode<K,V> parent,BSTNode<K,V> deleted,BSTNode<K,V> child){
        if(parent==null){
            root=child;
        }
        //删除的节点是父亲的左孩子，孩子就放父节点左边，右边同理
        else if (deleted==parent.left) {
            parent.left=child;
        }else{
            parent.right=child;
        }

    }


    //用来递归的函数
    private V doGet(BSTNode<K,V> node, K key){

        if(node==null){
            return null;    //没找到
        }
        int result= key.compareTo(node.key);
        if(result<0){
            //向左找
            return doGet(node.left,key);
        } else if (result>0) {
            return doGet(node.right,key);
        }else{
            //找到
            return node.value;
        }

    }

    //非递归的方式
    //尾递归：递归调用的最后一步是自身，尾递归转换成非递归实现性能会更高些
    public V noRecGet(K key){
        BSTNode<K,V> node=root;
        int result= key.compareTo(node.key);
        while(node!=null){
            //compareTo返回的是-1,则前一个key小于后一个，返回1则前一个大于后一个，返回0则相等
            if(result<0){
                node=node.left;
            }else if(result>0){
                node=node.right;
            }else{
                return node.value;
            }
        }
        return null;
    }

    //非递归
    public V noRecMin(BSTNode<K,V> node){
        while(node!=null){
            if(node.left==null){
                return node.value;
            }
            node=node.left;
        }
        return null;
    }




    //找到比Key小的所有的value
    public List<V> less(K key) {
        ArrayList<V> result = new ArrayList<>();
        BSTNode<K,V> p = root;
        LinkedList<BSTNode<K,V>> stack = new LinkedList<>();
        int res=key.compareTo(p.key);
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode<K,V> pop = stack.pop();
                if (res<0) {
                    result.add(pop.value);
                } else {
                    break;
                }
                p = pop.right;
            }
        }
        return result;
    }


    public List<V> greater(K key) {

        ArrayList<V> result = new ArrayList<>();
        BSTNode<K,V> p = root;
        LinkedList<BSTNode<K,V>> stack = new LinkedList<>();
        int res=key.compareTo(p.key);
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode<K,V> pop = stack.pop();
                if (res>0) {
                    result.add(pop.value);
                }
                p = pop.right;
            }
        }
        return result;

    }

    public List<V> between(K key1, K key2) {

        ArrayList<V> result = new ArrayList<>();
        BSTNode<K,V> p = root;
        LinkedList<BSTNode<K,V>> stack = new LinkedList<>();
        int res1=key1.compareTo(p.key);
        int res2=key2.compareTo(p.key);
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                BSTNode<K,V> pop = stack.pop();
                if (res1<0&&res2>0) {
                    result.add(pop.value);
                } else if (res2<0) {
                    break;
                }
                p = pop.right;
            }
        }
        return result;

    }
    //Reverse post-order,RLN 逆后序遍历
    public List<V> greaterReverse(K key) {

        ArrayList<V> result = new ArrayList<>();
        BSTNode<K,V> p = root;
        LinkedList<BSTNode<K,V>> stack = new LinkedList<>();
        int res=key.compareTo(p.key);
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.right;
            } else {
                BSTNode<K,V> pop = stack.pop();
                if (res>0) {
                    result.add(pop.value);
                }
                p = pop.left;
            }
        }
        return result;

    }
}
