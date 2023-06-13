package org.jeongmo.tree;

import java.util.logging.Logger;

public class BinarySearchTree {

    Tree root;
    public Tree addElement(Tree node, int value) {
        if (node == null) {
            node = new Tree(value);
        } else if (node.value > value) {
            node = addElement(node.left, value);
        } else if (node.value < value) {
            node = addElement(node.right, value);
        }

        return node;
    }

    public boolean search(Tree tree, int value) {

        if (tree == null) {
            return false;
        }
        if (tree.value == value) {
            return true;
        } else if (tree.value > value) {
            return search(tree.right, value);
        } else {
            return search(tree.left, value);
        }
    }
}
