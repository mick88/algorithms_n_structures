package com.michaldabski.trees.tests;

import com.michaldabski.trees.BinaryTree;
import junit.framework.TestCase;

/**
 * Created by Michal on 26/10/2015.
 */
public class BinaryTreeTest extends TestCase {

    BinaryTree<Integer> binaryTree;
    public void setUp() throws Exception {
        super.setUp();
        binaryTree = new BinaryTree<Integer>();
    }

    public void tearDown() throws Exception {
        binaryTree = null;
    }

    public void testIsBalanced_Empty() throws Exception {
        assertTrue(binaryTree.isBalanced());
    }

    public void testIsBalanced_One() throws Exception {
        BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(5);
        binaryTree.setRoot(root);
        assertTrue(binaryTree.isBalanced());
    }

    public void testIsBalanced_Left() throws Exception {
        BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(5);
        root.setLeft(new BinaryTree.Node<Integer>(3));
        binaryTree.setRoot(root);
        assertFalse(binaryTree.isBalanced());
    }

    public void testIsBalanced_Right() throws Exception {
        BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(5);
        root.setRight(new BinaryTree.Node<Integer>(3));
        binaryTree.setRoot(root);
        assertFalse(binaryTree.isBalanced());
    }

    public void testIsBalanced_balanced() throws Exception {
        BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(5);
        root.setRight(new BinaryTree.Node<Integer>(3));
        root.setLeft(new BinaryTree.Node<Integer>(3));
        binaryTree.setRoot(root);
        assertTrue(binaryTree.isBalanced());
    }

    public void testIsBalanced_More() throws Exception {
        BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(5);
        root.setRight(new BinaryTree.Node<Integer>(3));
        BinaryTree.Node<Integer> left = new BinaryTree.Node<Integer>(3);
        left.setRight(new BinaryTree.Node<Integer>(9));
        root.setLeft(left);
        binaryTree.setRoot(root);
        assertFalse(binaryTree.isBalanced());
    }

    public void testIsBalanced_More_Balanced() throws Exception {
        BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(5);
        root.setRight(new BinaryTree.Node<Integer>(3));

        BinaryTree.Node<Integer> left = new BinaryTree.Node<Integer>(3);
        left.setRight(new BinaryTree.Node<Integer>(9));
        left.setLeft(new BinaryTree.Node<Integer>(9));
        root.setLeft(left);

        binaryTree.setRoot(root);
        assertFalse(binaryTree.isBalanced());
    }

    public void testIsBalanced_Balanced_EdgeCase() throws Exception {
        BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(5);
        BinaryTree.Node<Integer> right = new BinaryTree.Node<Integer>(3);
        right.setLeft(new BinaryTree.Node<Integer>(10));
        root.setRight(right);

        BinaryTree.Node<Integer> left = new BinaryTree.Node<Integer>(3);
        left.setRight(new BinaryTree.Node<Integer>(19));
        left.setLeft(new BinaryTree.Node<Integer>(9));
        root.setLeft(left);

        binaryTree.setRoot(root);
        assertTrue(String.format("Tree should be balanced: %s", binaryTree), binaryTree.isBalanced());
    }
}