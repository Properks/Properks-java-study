package org.jeongmo.tree;

import java.util.logging.Logger;

public class BinarySearchTree {


    public Tree addElement(Tree tree, int value) {
        if (tree == null) {
            tree = new Tree(value);
        }

        if (tree.value > value) {
            addElement(tree.right, value);
        } else if (tree.value < value) {
             addElement(tree.left, value);
        }

        return tree;
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
