package org.jeongmo.tree;

import java.util.logging.Logger;

public class Tree {
    int value;
    Tree left;
    Tree right;

    private static final Logger logger = Logger.getLogger(Tree.class.getName());

    public Tree() {
    }

    public Tree(int value) {
        this.value = value;
        this.left = this.right = null;
    }

    public Tree(int value, Tree left, Tree right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Tree(Tree scr) {
        this.value = scr.value;
        this.left = null;
        this.right = null;
        if (scr.left != null) {
            this.left = new Tree(scr.left.value, scr.left.left, scr.left.right);
        }
        if (scr.right != null) {
            this.right = new Tree(scr.right.value, scr.right.left, scr.right.right);
        }
    }

    public static void inorder(Tree list) {

        if (list != null) {
            inorder(list.left);
            logger.info(() -> String.valueOf(list.value));
            inorder(list.right);
        }
    }
    public static void preorder(Tree list) {

        if (list != null) {
            logger.info(() -> String.valueOf(list.value));
            preorder(list.left);
            preorder(list.right);
        }
    }

    public static void postorder(Tree list) {

        if (list != null) {
            postorder(list.left);
            postorder(list.right);
            logger.info(() -> String.valueOf(list.value));
        }
    }



}
