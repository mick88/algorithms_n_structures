package com.michaldabski.trees;


import com.michaldabski.linked_lists.LinkedList;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Michal on 26/10/2015.
 */
public class BinaryTree<T> {
    public static class Node<T> {
        final T value;
        Node<T> left = null;
        Node<T> right = null;
        Node<T> parent = null;

        public void setParent(Node<T> parent) {
            this.parent = parent;
        }

        public Node<T> getParent() {
            return parent;
        }

        protected Node<T> getNextNode(Node<T> after) {
            if (left != null && left != after && right != after) {
                return left;
            } else if (right != null && right != after) {
                return right;
            } else if (parent != null) {
                return parent.getNextNode(this);
            } else {
                return null;
            }
        }

        /**
         * Gets next node in order after this node.
         * NULL if this is te last node.
         */
        public Node<T> getNextNode() {
            return getNextNode(this);
        }

        public Node<T> getFirstCommonAncestor(Node<T> node) {
            final Set<Node<T>> parents = node.getParents();
            Node<T> thisNode = this;
            while (thisNode != null) {
                if (parents.contains(thisNode)) {
                    return thisNode;
                }
                thisNode = thisNode.parent;
            }
            throw new RuntimeException(String.format("Could not find common ancestor for %s and %s", toString(), node));
        }

        /**
         * Gets set of nodes from this node to the root, including this node
         */
        public Set<Node<T>> getParents() {
            final Set<Node<T>> parents = new HashSet<Node<T>>();
            Node<T> node = this;
            while (node != null) {
                parents.add(node);
                node = node.parent;
            }
            return parents;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
            left.setParent(this);
        }

        public Node<T> getLeft() {
            return left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
            right.setParent(this);
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

        public int size() {
            int size = 1;
            if (left != null) size += left.size();
            if (right != null) size += right.size();
            return size;
        }

        static <T> Node<T> nodeFromArray(T... values) {
            final int mid = values.length / 2;
            Node<T> node = new Node<T>(values[mid]);
            if (mid > 0) {
                final T[] leftValues = Arrays.copyOf(values, mid);
                node.setLeft(nodeFromArray(leftValues));
            }
            if (mid < values.length - 1) {
                final T[] rightValues = Arrays.copyOfRange(values, mid + 1, values.length);
                node.setRight(nodeFromArray(rightValues));
            }

            return node;
        }
    }

    Node<T> root = null;

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public Node<T> getRoot() {
        return root;
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

    /**
     * Create balanced tree from sorted array
     */
    public static <T extends Comparable<T>> BinaryTree<T> fromArray(T... sortedArray) {
        for (int i = 1; i < sortedArray.length; i++) {
            if (sortedArray[i].compareTo(sortedArray[i - 1]) < 0)
                throw new IllegalStateException("Expected array sorted in ascending order. Actual array: " + sortedArray.toString());
        }

        BinaryTree<T> tree = new BinaryTree<T>();
        tree.setRoot(Node.nodeFromArray(sortedArray));
        return tree;
    }

    public int size() {
        return root == null ? 0 : root.size();
    }

    /**
     * Gets linked list for values at each depth of the array
     * @return array containing a linked list fo each depth level in this tree
     */
    public LinkedList<T>[] getLinkedLists() {
        if (root == null) return new LinkedList[0];
        // create linked lists and map level to the last node
        final LinkedList[] linkedLists = new LinkedList[root.calculateMaxDepth()];
        for (int i = 0; i < linkedLists.length; i++) {
            linkedLists[i] = new LinkedList<T>();
        }
        populateLinkedLists(0, root, linkedLists);
        return linkedLists;
    }

    protected void populateLinkedLists(int level, Node<T> node, LinkedList[] valuesList) {
        if (node != null) {
            valuesList[level].addValue(node.value);
            populateLinkedLists(level + 1, node.left, valuesList);
            populateLinkedLists(level + 1, node.right, valuesList);
        }
    }
}
