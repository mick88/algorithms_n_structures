package com.michaldabski.graphs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Michal on 27/10/2015.
 */
public class Graph<T> {
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
         * @return collection of newly created created nodes
         */
        public Collection<GraphNode<T>> createNeighbours(T... values) {
            Collection<GraphNode<T>> created = new ArrayList<GraphNode<T>>(values.length);
            for (T value : values) {
                final GraphNode<T> node = new GraphNode<T>(value);
                created.add(node);
            }
            links.addAll(created);
            return created;
        }
    }

    GraphNode<T> root;

    public void setRoot(GraphNode<T> root) {
        this.root = root;
    }

    public GraphNode<T> getRoot() {
        return root;
    }
}
