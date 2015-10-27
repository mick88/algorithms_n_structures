package com.michaldabski.graphs.tests;

import com.michaldabski.graphs.DirectedGraph;
import junit.framework.TestCase;

import java.util.Collection;
import java.util.List;

/**
 * Created by Michal on 27/10/2015.
 */
public class DirectedGraphTest extends TestCase {

    DirectedGraph<Integer> directedGraph;

    public void setUp() throws Exception {
        super.setUp();
        directedGraph = new DirectedGraph<Integer>();
    }

    public void tearDown() throws Exception {
        directedGraph = null;
    }

    public void testCreateNeighbours() throws Exception {
        final DirectedGraph.GraphNode<Integer> root = new DirectedGraph.GraphNode<Integer>(5);
        directedGraph.setRoot(root);
        final Collection<DirectedGraph.GraphNode<Integer>> neighbours = root.createNeighbours(1, 2, 3, 4);

        assertNotNull(neighbours);
        assertEquals(4, neighbours.size());
    }

    public void testHasRoute() throws Exception {
        DirectedGraph.GraphNode<Integer> root = new DirectedGraph.GraphNode<Integer>(1);
        directedGraph.setRoot(root);

        DirectedGraph.GraphNode<Integer> node2 = root
                .createNeighbours(1, 2).get(1)
                .createNeighbours(3, 4, 5, 6).get(3)
                .createNeighbours(7, 8, 9).get(2);

        assertTrue(DirectedGraph.hasRoute(root, node2));
        assertTrue(DirectedGraph.hasRoute(root.getLinks().get(1), node2));

        assertFalse(DirectedGraph.hasRoute(node2, root));
        assertFalse(DirectedGraph.hasRoute(root.getLinks().get(0), node2));
    }
}