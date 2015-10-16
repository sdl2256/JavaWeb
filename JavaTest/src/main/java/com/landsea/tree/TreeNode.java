package com.landsea.tree;

/**
 * Created by SDL on 2015/8/25.
 */
public class TreeNode<T> {
    public T data; //数据域
    public TreeNode<T> child, sibling;//孩子、兄弟结点；

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public TreeNode<T> getChild() {
        return child;
    }

    public void setChild(TreeNode<T> child) {
        this.child = child;
    }

    public TreeNode<T> getSibling() {
        return sibling;
    }

    public void setSibling(TreeNode<T> sibling) {
        this.sibling = sibling;
    }
}
