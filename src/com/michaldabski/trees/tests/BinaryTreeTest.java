package com.michaldabski.trees.tests;

import com.michaldabski.linked_lists.LinkedList;
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
        assertTrue(binaryTree.isBalanced());
    }

    public void testIsBalanced_Right() throws Exception {
        BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(5);
        root.setRight(new BinaryTree.Node<Integer>(3));
        binaryTree.setRoot(root);
        assertTrue(binaryTree.isBalanced());
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
        assertTrue(binaryTree.isBalanced());
    }

    public void testIsBalanced_More_Balanced() throws Exception {
        BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(5);
        root.setRight(new BinaryTree.Node<Integer>(3));

        BinaryTree.Node<Integer> left = new BinaryTree.Node<Integer>(3);
        left.setRight(new BinaryTree.Node<Integer>(9));
        left.setLeft(new BinaryTree.Node<Integer>(9));
        root.setLeft(left);

        binaryTree.setRoot(root);
        assertTrue(binaryTree.isBalanced());
    }

    public void testIsBalanced_More_Unbalanced() throws Exception {
        BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(5);

        BinaryTree.Node<Integer> left = new BinaryTree.Node<Integer>(3);
        left.setRight(new BinaryTree.Node<Integer>(9));
        BinaryTree.Node<Integer> left1 = new BinaryTree.Node<Integer>(9);
        left1.setLeft(new BinaryTree.Node<Integer>(43));
        left.setLeft(left1);
        root.setLeft(left);

        binaryTree.setRoot(root);
        assertFalse(binaryTree.toString(), binaryTree.isBalanced());
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

    public void testCalculateMinDepth() throws Exception {
        BinaryTree.Node<Integer> node = new BinaryTree.Node<Integer>(5);
        assertEquals(1, node.calculateMinDepth());
        node.setLeft(new BinaryTree.Node<Integer>(3));
        assertEquals(1, node.calculateMinDepth());
        node.setRight(new BinaryTree.Node<Integer>(3));
        assertEquals(2, node.calculateMinDepth());
    }

    public void testCalculateMaxDepth() throws Exception {
        BinaryTree.Node<Integer> node = new BinaryTree.Node<Integer>(5);
        assertEquals(1, node.calculateMaxDepth());
        node.setLeft(new BinaryTree.Node<Integer>(3));
        assertEquals(2, node.calculateMaxDepth());
        node.setRight(new BinaryTree.Node<Integer>(3));
        assertEquals(2, node.calculateMaxDepth());
    }
}