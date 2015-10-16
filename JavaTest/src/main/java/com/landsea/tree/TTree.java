package com.landsea.tree;

/**
 * Created by SDL on 2015/8/25.
 */
public interface TTree<T> {
    boolean isEmpty();//判断是否空树

    TreeNode<T> getChild(TreeNode<T> p, int i);//返回p第i个孩子

    TreeNode<T> getParent(TreeNode<T> node);//返回node的父母

    int count();//树的节点个数

    int heigth();//树的高度

    TreeNode<T> search(T x);//查找并返回元素为x的点

    void preOrder();//前根次序遍历树

    void postOrder();//后根次序遍历树

    void levelOrder();//按层次遍历树

    void insertRoot(T x);//插入元素x作为根节点

    TreeNode<T> insertChild(TreeNode<T> p, T x, int i);//插入孩子

    void removeChild(TreeNode<T> p, int i); //删除孩子

}
