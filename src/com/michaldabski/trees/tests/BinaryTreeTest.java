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

    public void testFromArray() throws Exception {
        try {
            BinaryTree.fromArray(1, 2, 3, 4, 5, 4);
            fail("Array should not be allowed");
        } catch (IllegalStateException ignored) {
        }

        final BinaryTree<Integer> tree = BinaryTree.fromArray(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);

        System.out.println(tree);
        assertEquals(15, tree.size());
        assertTrue(tree.isBalanced());
        assertEquals(4, tree.getRoot().calculateMaxDepth());
    }

    public void testSize() throws Exception {
        assertEquals(0, binaryTree.size());
        final BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(2);
        binaryTree.setRoot(root);
        assertEquals(1, binaryTree.size());
        root.setLeft(new BinaryTree.Node<Integer>(4));
        root.setRight(new BinaryTree.Node<Integer>(5));
        assertEquals(3, binaryTree.size());
    }

    public void testGetLinkedLists() throws Exception {
        BinaryTree.Node<Integer> root = new BinaryTree.Node<Integer>(1);

        BinaryTree.Node<Integer> left = new BinaryTree.Node<Integer>(2);
        root.setLeft(left);
        BinaryTree.Node<Integer> right = new BinaryTree.Node<Integer>(3);
        root.setRight(right);

        left.setLeft(new BinaryTree.Node<Integer>(4));
        left.setRight(new BinaryTree.Node<Integer>(5));

        right.setLeft(new BinaryTree.Node<Integer>(6));
        BinaryTree.Node<Integer> lastNode = new BinaryTree.Node<Integer>(7);
        right.setRight(lastNode);
        lastNode.setRight(new BinaryTree.Node<Integer>(100));
        binaryTree.setRoot(root);

        LinkedList<Integer>[] linkedLists = binaryTree.getLinkedLists();
        assertEquals(linkedLists.length, 4);

        LinkedList<Integer> rootList = linkedLists[0];
        assertEquals(1, rootList.size());
        assertEquals(1, (int) rootList.getItem(0));

        LinkedList<Integer> secondLevelList = linkedLists[1];
        assertEquals(secondLevelList.size(), 2);
        assertEquals(2, (int)secondLevelList.getItem(0));
        assertEquals(3, (int)secondLevelList.getItem(1));

        LinkedList<Integer> thirdLevelList = linkedLists[2];
        assertEquals(thirdLevelList.size(), 4);
        System.out.println(thirdLevelList.toString());
        assertEquals(4, (int)thirdLevelList.getItem(0));
        assertEquals(5, (int)thirdLevelList.getItem(1));
        assertEquals(6, (int)thirdLevelList.getItem(2));
        assertEquals(7, (int)thirdLevelList.getItem(3));

        LinkedList<Integer> lastLevelList = linkedLists[3];
        assertEquals(lastLevelList.size(), 1);
        assertEquals(100, (int)lastLevelList.getItem(0));
    }
}