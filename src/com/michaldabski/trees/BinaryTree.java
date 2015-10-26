package com.michaldabski.trees;


/**
 * Created by Michal on 26/10/2015.
 */
public class BinaryTree<T> {
    public static class Node<T> {
        final T value;
        Node<T> left = null;
        Node<T> right = null;

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public Node(T value) {
            this.value = value;
        }

        /**
         * Check whether child nodes below this node are balanced
         *
         * @param depth base depth of this node
         * @return depth of furthest child, or -1 if children are not balanced
         */
        int isBalanced(int depth) {
            if (left == null && right == null) {
                // both children are null
                return depth;
            } else if (left == null || right == null) {
                // either child is null
                return -1;
            } else {
                // both children are not null
                int leftDepth = left.isBalanced(depth + 1);
                int rightDepth = right.isBalanced(depth + 1);
                return leftDepth == rightDepth ? leftDepth : -1;
            }
        }

        @Override
        public String toString() {
            return String.format("%s [%s, %s]", value, left, right);
        }
    }

    Node<T> root = null;

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public boolean isBalanced() {
        if (root == null) return true;
        return root.isBalanced(1) >= 1;
    }

    @Override
    public String toString() {
        return String.format("[%s]", root);
    }
}
