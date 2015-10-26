package com.michaldabski.trees.tests;

import com.michaldabski.trees.Tree;
import junit.framework.TestCase;

/**
 * Created by Michal on 26/10/2015.
 */
public class TreeTest extends TestCase {

    Tree<Integer> tree;
    public void setUp() throws Exception {
        super.setUp();
        tree = new Tree<Integer>();
    }

    public void tearDown() throws Exception {
        tree = null;
    }

    public void testIsBalanced_Empty() throws Exception {
        assertTrue(tree.isBalanced());
    }

    public void testIsBalanced_One() throws Exception {
        Tree.Node<Integer> root = new Tree.Node<Integer>(5);
        tree.setRoot(root);
        assertTrue(tree.isBalanced());
    }

    public void testIsBalanced_Left() throws Exception {
        Tree.Node<Integer> root = new Tree.Node<Integer>(5);
        root.setLeft(new Tree.Node<Integer>(3));
        tree.setRoot(root);
        assertFalse(tree.isBalanced());
    }

    public void testIsBalanced_Right() throws Exception {
        Tree.Node<Integer> root = new Tree.Node<Integer>(5);
        root.setRight(new Tree.Node<Integer>(3));
        tree.setRoot(root);
        assertFalse(tree.isBalanced());
    }

    public void testIsBalanced_balanced() throws Exception {
        Tree.Node<Integer> root = new Tree.Node<Integer>(5);
        root.setRight(new Tree.Node<Integer>(3));
        root.setLeft(new Tree.Node<Integer>(3));
        tree.setRoot(root);
        assertTrue(tree.isBalanced());
    }

    public void testIsBalanced_More() throws Exception {
        Tree.Node<Integer> root = new Tree.Node<Integer>(5);
        root.setRight(new Tree.Node<Integer>(3));
        Tree.Node<Integer> left = new Tree.Node<Integer>(3);
        left.setRight(new Tree.Node<Integer>(9));
        root.setLeft(left);
        tree.setRoot(root);
        assertFalse(tree.isBalanced());
    }

    public void testIsBalanced_More_Balanced() throws Exception {
        Tree.Node<Integer> root = new Tree.Node<Integer>(5);
        root.setRight(new Tree.Node<Integer>(3));

        Tree.Node<Integer> left = new Tree.Node<Integer>(3);
        left.setRight(new Tree.Node<Integer>(9));
        left.setLeft(new Tree.Node<Integer>(9));
        root.setLeft(left);

        tree.setRoot(root);
        assertFalse(tree.isBalanced());
    }
}