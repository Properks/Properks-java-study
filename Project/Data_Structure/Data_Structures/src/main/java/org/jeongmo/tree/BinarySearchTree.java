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
        bst.root = bst.addElement(bst.getRoot(), 36);
        bst.root = bst.addElement(bst.getRoot(), 30);
        bst.root = bst.addElement(bst.getRoot(), 29);
        bst.root = bst.addElement(bst.getRoot(), 25);
        bst.root = bst.addElement(bst.getRoot(), 35);

        if (bst.search(bst.getRoot(), 14)) {
            logger.info("14 is in tree");
        }

        Tree.inorder(bst.getRoot());
        bst.remove(bst.getRoot(), 14);
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

    public Tree remove(Tree tree, int value) {
        if (tree == null) {
            logger.info(() -> "Can't found" + value);
            return null;
        }

        if (tree.value == value) {
            if (tree.left == null && tree.right == null) {
                return null;
            } else if (tree.right != null && tree.left != null) {
                tree.value = getMax(tree.left);
                tree.left = remove(tree.left, tree.value);
            } else if (tree.right == null) {
                tree.value = tree.left.value;
                tree.left = tree.left.left;
                tree.right = tree.left.right;
            } else {
                tree.value = tree.right.value;
                tree.left = tree.right.left;
                tree.right = tree.right.right;
            }
        } else if (tree.value > value) {
            tree.left = remove(tree.left, value);
        }
        else {
            tree.right = remove(tree.right, value);
        }
        return tree;
    }

    public int getMax(Tree tree) {
        int max = tree.value;
        Tree currentTree = tree;
        while (currentTree.right != null) {
            currentTree = currentTree.right;
            max = currentTree.value;
        }
        return max;
    }

    public Tree getRoot() {
        return root;
    }
}
