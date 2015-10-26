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
         * Gets maximum depth of the child nodes below this node, inclusive
         */
        public int calculateMaxDepth() {
            if (left == null && right == null) {
                return 1;
            } else if (left != null && right != null) {
                return Math.max(left.calculateMaxDepth(), right.calculateMaxDepth()) + 1;
            } else if (left != null) {
                return left.calculateMaxDepth() + 1;
            } else {
                return right.calculateMaxDepth() + 1;
            }
        }

        /**
         * Gets minimum depth of the child nodes below this node, inclusive
         */
        public int calculateMinDepth() {
            if (left == null || right == null) {
                // either child is null
                return 1;
            } else {
                // both children are not null
                int leftMinDepth = left.calculateMinDepth();
                int rightMinDepth = right.calculateMinDepth();
                return Math.max(leftMinDepth, rightMinDepth) + 1;
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

    /**
     * Checks whether this tree is balanced by comparing minimum and maximum depth of the child nodes
     */
    public boolean isBalanced() {
        if (root == null) return true;
        return root.calculateMaxDepth() - root.calculateMinDepth() <= 1;
    }

    @Override
    public String toString() {
        return String.format("[%s]", root);
    }
}
