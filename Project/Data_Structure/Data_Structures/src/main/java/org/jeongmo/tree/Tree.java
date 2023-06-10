package org.jeongmo.tree;

import java.util.logging.Logger;

public class Tree {
    int value;
    Tree left;
    Tree right;

    private static final Logger logger = Logger.getLogger(Tree.class.getName());

    public Tree() {}

    public Tree(int value) {
        this.value = value;
        this.left = this.right = null;
    }

    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void inorder(Tree list) {

        if (list != null) {
            inorder(list.left);
            logger.info(() -> String.valueOf(this.value));
            inorder(list.right);
        }
    }
    public void preorder(Tree list) {

        if (list != null) {
            logger.info(() -> String.valueOf(this.value));
            preorder(list.left);
            preorder(list.right);
        }
    }

    public void postorder(Tree list) {

        if (list != null) {
            postorder(list.left);
            postorder(list.right);
            logger.info(() -> String.valueOf(this.value));
        }
    }

}
