package com.michaldabski.graphs;

import com.michaldabski.linked_lists.LinkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Michal on 27/10/2015.
 */
public class DirectedGraph<T> {
    public static class GraphNode<T> {
        final T value;
        final List<GraphNode<T>> links = new ArrayList<GraphNode<T>>();

        public GraphNode(T value) {
            this.value = value;
        }

        public List<GraphNode<T>> getLinks() {
            return links;
        }

        @Override
        public String toString() {
            return value == null ? "null" : value.toString();
        }

        /**
         * Shorthand to create neighbour nodes with specified values
         * @param values values for neighbours
         * @return list of newly created created nodes
         */
        public List<GraphNode<T>> createNeighbours(T... values) {
            List<GraphNode<T>> created = new ArrayList<GraphNode<T>>(values.length);
            for (T value : values) {
                final GraphNode<T> node = new GraphNode<T>(value);
                created.add(node);
            }
            links.addAll(created);
            return created;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof GraphNode<?>) {
                return ((GraphNode) obj).value.equals(this.value);
            }
            return super.equals(obj);
        }
    }

    GraphNode<T> root;

    public void setRoot(GraphNode<T> root) {
        this.root = root;
    }

    public GraphNode<T> getRoot() {
        return root;
    }

    /**
     * Finds whether there's a route from node1 to node2
     * @param node1 origin node
     * @param node2 destination node
     * @return true if there's a route from node1 to node2, or false if such route does not exist
     */
    public static <T> boolean hasRoute(GraphNode<T> node1, GraphNode<T> node2) {
        final List<GraphNode<T>> links = node1.getLinks();
        if (links.contains(node2)) return true;
        for (GraphNode<T> node : node1.getLinks()) {
            if (hasRoute(node, node2)) return true;
        }
        return false;
    }
}
