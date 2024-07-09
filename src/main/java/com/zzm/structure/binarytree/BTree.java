package com.zzm.structure.binarytree;



import java.util.Arrays;

/**
 * @BelongsProject: leet
 * @BelongsPackage: com.zzm.structure.binarytree
 * @Author: zzm
 * @CreateTime: 2024-01-28  11:54
 * @Description: TODO
 * @Version: 1.0
 */
//B树
public class BTree {

    Node root;

    int t;//树中节点的最小度数
    final int MIN_KEY_NUMBER;//最小关键字个数
    final int MAX_KEY_NUMBER;//最大关键字个数
    static class Node {
        boolean leaf = true;//代表节点是否是叶子节点
        int keyNumber;//有效关键字数目
        int t;//最小度数（这个节点最少有几个孩子）
        int[] keys;//关键字
        Node[] children;//孩子

        public Node(int t) {
            this.t = t;//最小孩子数>=2
            this.keys = new int[2 * t - 1];//比孩子数少一个
            this.children = new Node[2 * t];//最小度数*2（左边+右边）就是可能拥有最多的孩子数
        }

        @Override
        public String toString() {
            return Arrays.toString(Arrays.copyOfRange(keys, 0, keyNumber));
        }

        //多路查找
        Node get(int key){
            int i=0;
            while(i<keyNumber){
                if(keys[i]==key){
                    return this;
                }
                if(keys[i]>key){
                    //当前循环没找到
                    break;
                }
                i++;
            }
            //执行到此时，keys[i]>key 或者 i=keyNumber,超出索引范围
            if(leaf){
                return null;
            }
            //退出循环时i的值就是要去第i个孩子进行查找，递归调用就可以了
            return children[i].get(key);
        }

        //向keys指定索引处插入key
        //[1,3,5]
        void insertKey(int key, int index) {
            //五个参数：原数组，原数组的起始索引，目标数组，目标数组的起始索引，要复制的长度
            System.arraycopy(keys, index, keys, index + 1, keyNumber - index);
            keys[index] = key;
            keyNumber++;
        }
        //向children 指定索引处插入child
        void insertChild(Node child, int index) {
            System.arraycopy(children, index, children, index + 1, keyNumber - index);
            children[index] = child;
        }

        int removeKey(int index) {
            int t = keys[index];
            System.arraycopy(keys, index + 1, keys, index, --keyNumber - index);
            return t;
        }

        int removeLeftmostKey() {
            return removeKey(0);
        }

        int removeRightmostKey() {
            return removeKey(keyNumber - 1);
        }

        Node removeChild(int index) {
            Node t = children[index];
            System.arraycopy(children, index + 1, children, index, keyNumber - index);
            children[keyNumber] = null;
            return t;
        }

        Node removeLeftmostChild() {
            return removeChild(0);
        }

        Node removeRightmostChild() {
            return removeChild(keyNumber);
        }

        void moveToLeft(Node left) {
            int start = left.keyNumber;
            if (!leaf) {
                for (int i = 0; i <= keyNumber; i++) {
                    left.children[start + i] = children[i];
                }
            }
            for (int i = 0; i < keyNumber; i++) {
                left.keys[left.keyNumber++] = keys[i];
            }
        }

        Node leftSibling(int index) {
            return index > 0 ? children[index - 1] : null;
        }

        Node rightSibling(int index) {
            return index == keyNumber ? null : children[index + 1];
        }


    }

    //根节点


    //默认无参构造
    public BTree() {
        this(2);
    }

    public BTree(int t) {
        this.t = t;
        MIN_KEY_NUMBER=t-1;
        MAX_KEY_NUMBER=2*t-1;
        root =new Node(t);
    }


    //1.判断一个key在树中是否存在
    public boolean contains(int key){
        return root.get(key)!=null;
    }

    //2.新增
    public void put(int key){
        doPut(root,key,null,0);

    }

    private void doPut(Node node,int key,Node parent,int index){
        int i=0;
        while(i<node.keyNumber){
            if(node.keys[i]==key){
                return;//更新的逻辑
            }
            if(node.keys[i]>key){
                //当前循环没找到
                break;
            }
            i++;//i的值就是找到了插入位置i
        }
        //是叶子节点就可以直接插入
        if(node.leaf){
            node.insertKey(key,i);
            //上限
        }else{
            //在第i个孩子节点完成插入
            doPut(node.children[i],key,node,i);
            //上限
        }
        if(node.keyNumber==MAX_KEY_NUMBER){
            split(node,parent,index);
        }
    }

    private void split(Node left,Node parent,int index){
        if(parent==null){//分裂的是根节点，创建新的节点，把根节点变成新的节点的孩子
            Node newRoot=new Node(t);
            newRoot.leaf=false;
            newRoot.insertChild(left,0);
            this.root=newRoot;
            parent=newRoot;//创建新的根节点之后，继续走下面代码进行分裂逻辑
        }
        //1.创建right节点，把left中的t之后的key和children拷贝到right
        Node right=new Node(t);//整个树中所有的t值是一样的
        right.leaf=left.leaf;
        System.arraycopy(left.keys,t,right.keys,0,t-1);
        if(!left.leaf){
            System.arraycopy(left.children,t,right.children,0,t);//孩子拷贝比key多一个
        }
        right.keyNumber=t-1;
        //2.中间的key（t-1）提升到父节点
        int mid=left.keys[t-1];
        parent.insertKey(mid,index);
        //3.把right设置为parent的孩子
        parent.insertChild(right,index+1);

    }

    //3.删除
    public void remove(int key){
        doRemove(null,root,0,key);
    }

    private void doRemove(Node parent,Node node,int index,int key){
        int i=0;
        while(i<node.keyNumber){
           if(node.keys[i]>=key){
               break;
           }
           i++;//两层含义：1)可能找到了：代表待删除key的索引。2)没找到：代表到第i个孩子继续查找
        }
        //区分两层含义，就看i是否在有效范围内
        //抽取方法快捷键：ctrl+alt+m
        if(node.leaf){//是不是叶子
            if(!found(node, key, i)){//case 1 当前节点是叶子节点，没找到
                return ;//不再向下走
            }else{//case 2 当前节点是叶子节点，找到了
                node.removeKey(i);//删除指定索引处的key
            }
        }else{
            if(!found(node, key, i)){//case 3 当前节点是非叶子节点，没找到
                //继续到第i个孩子里面进行查找
                doRemove(node,node.children[i],i,key);
            }else{//case 4 当前节点是非叶子节点，找到了
                //1)找到后继的key
                Node s=node.children[i+1];//到比key值大的孩子节点机型查找
                while(!s.leaf){
                    s=s.children[0];//不是叶子节点就一直向左走
                }
                int skey=s.keys[0];//找到了最小的key
                //2)调换待删除的key
                node.keys[i]=skey;
                //3)删除后继key
                doRemove(node,node.children[i+1],i+1,skey);
            }
        }

        if(node.keyNumber<MIN_KEY_NUMBER){
            //调整平衡 case 5 case6
            balance(parent, node, index);
        }
    }

    private void balance(Node parent,Node x,int i){
        //case6 根节点
        if(x==root){
            if(root.keyNumber==0 && root.children[0]!=null){
                root=root.children[0];//根节点的孩子节点变成新的根节点
            }
            return;
        }
        Node left=parent.leftSibling(i);//左兄弟
        Node right=parent.rightSibling(i);//右兄弟
        if(left!=null&&left.keyNumber>MIN_KEY_NUMBER){
            //case5-1:左边富裕，右旋
            //a) 父节点的key旋转下来
            x.insertKey(parent.keys[i-1],0);
            if(!left.leaf){
                //b)处理一下左边兄弟的最右边的孩子，转移到自己的最左侧
                x.insertChild(left.removeRightmostChild(),0);
            }
            //c)将兄弟节点的key移到父节点
            parent.keys[i-1]=left.removeRightmostKey();
            return;
        }
        if(right!=null&&right.keyNumber>MIN_KEY_NUMBER){
            //case5-2:右边富裕，左旋
            //a) 父节点中的后继的key旋转下来
            x.insertKey(parent.keys[i],x.keyNumber);
            //b)right最小的孩子换爹
            if(!right.leaf){
                //处理一下右边兄弟的最左边的孩子，转移到自己的最右侧
                x.insertChild(right.removeLeftmostChild(),x.keyNumber);
            }
            //c)将兄弟节点的最小的key移到父节点
            parent.keys[i]=right.removeLeftmostKey();
            return;
        }
        //case5-3:左右都穷，合并
        //有左兄弟，就和左兄弟合并
        if(left!=null){
            //把被调整节点从父节点移除
            parent.removeChild(i);
            //从父节点移动一个索引为i-1的key到左兄弟
            left.insertKey(parent.removeKey(i-1),left.keyNumber);
            //把自己的key和children都拷贝到左兄弟
            x.moveToLeft(left);
        }else{
            //向自己合并
            parent.removeChild(i+1);
            x.insertKey(parent.removeKey(i),x.keyNumber);
            right.moveToLeft(x);
        }
    }

    private static boolean found(Node node, int key, int i) {
        return i < node.keyNumber && node.keys[i] == key;
    }


}
