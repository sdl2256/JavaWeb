package com.landsea.tree;

/**
 * Created by SDL on 2015/8/25.
 */
public class Tree<T> implements TTree<T> {
    public TreeNode<T> root;

    public TreeNode<T> getRoot() {
        return root;
    }

    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }

    @Override
    public boolean isEmpty() {

        if (root == null)
            return true;
        return false;
    }

    @Override
    public TreeNode<T> getChild(TreeNode<T> p, int i) {
        return null;
    }

    @Override
    public TreeNode<T> getParent(TreeNode<T> node) {
        return null;
    }

    @Override
    public int count() {
        return 0;
    }

    @Override
    public int heigth() {
        return 0;
    }

    @Override
    public TreeNode<T> search(T x) {
        return null;
    }

    @Override
    public void preOrder() {

    }

    @Override
    public void postOrder() {

    }

    @Override
    public void levelOrder() {

    }

    @Override
    public void insertRoot(T x) {
        root.data = x;
    }

    @Override
    public TreeNode<T> insertChild(TreeNode<T> p, T x, int i) {
        return null;
    }

    @Override
    public void removeChild(TreeNode<T> p, int i) {

    }
}
