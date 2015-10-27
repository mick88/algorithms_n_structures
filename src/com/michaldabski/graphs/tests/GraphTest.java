package com.michaldabski.graphs.tests;

import com.michaldabski.graphs.Graph;
import junit.framework.TestCase;

import java.util.Collection;

/**
 * Created by Michal on 27/10/2015.
 */
public class GraphTest extends TestCase {

    Graph<Integer> graph;

    public void setUp() throws Exception {
        super.setUp();
        graph = new Graph<Integer>();
    }

    public void tearDown() throws Exception {
        graph = null;
    }

    public void testCreateNeighbours() throws Exception {
        final Graph.GraphNode<Integer> root = new Graph.GraphNode<Integer>(5);
        graph.setRoot(root);
        final Collection<Graph.GraphNode<Integer>> neighbours = root.createNeighbours(1, 2, 3, 4);

        assertNotNull(neighbours);
        assertEquals(4, neighbours.size());
    }
}