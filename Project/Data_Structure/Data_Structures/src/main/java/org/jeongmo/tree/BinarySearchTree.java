package org.jeongmo.tree;

import java.util.logging.Logger;

public class BinarySearchTree {

    private static final Logger logger = Logger.getLogger(BinarySearchTree.class.getName());
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(27);
        bst.root = bst.addElement(bst.getRoot(), 20);
        bst.root = bst.addElement(bst.getRoot(), 10);
        bst.root = bst.addElement(bst.getRoot(), 14);
        bst.root = bst.addElement(bst.getRoot(), 32);
        if (bst.search(bst.getRoot(), 14)) {
            logger.info("14 is in tree");
        }
        Tree.inorder(bst.getRoot());

    }
    Tree root;

    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(int value) {
        root = new Tree(value);
    }

    public Tree addElement(Tree node, int value) {
        if (node == null) {
            node = new Tree(value);
        } else if (node.value > value) {
            node.left = addElement(node.left, value);
        } else if (node.value < value) {
            node.right = addElement(node.right, value);
        }
        return node;
    }

    public boolean search(Tree tree, int value) {

        if (tree == null) {
            return false;
        }
        if (tree.value == value) {
            return true;
        } else if (tree.value < value) {
            return search(tree.right, value);
        } else {
            return search(tree.left, value);
        }
    }

    public Tree getRoot() {
        return root;
    }
}
