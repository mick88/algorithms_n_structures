package com.michaldabski.linked_lists;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Michal on 08/09/2015.
 */
public class LinkedList<T> {
    public static class Node<T> {
        public Node<T> next;
        T data;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return String.format("[%s]", data.toString());
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Node<?>) {
                final Node otherNode = (Node) obj;
                if (Objects.equals(this.data, otherNode.data)) return true;
            }
            return false;
        }

        public T getData() {
            return data;
        }

        void addNode(Node<T> newNode) {
            if (next == null) next = newNode;
            else next.addNode(newNode);
        }
    }

    public Node<T> head = null;

    public LinkedList(T... values) {
        if (values == null) addValue(null);
        else for (T value : values) addValue(value);
    }

    public Node<T> addValue(T value) {
        final Node<T> node = new Node<T>(value);
        if (head == null) head = node;
        else head.addNode(node);
        return node;
    }

    @Override
    public String toString() {
        if (head == null) return "";
        Node node = head;
        String result = node.toString();
        while ((node = node.next) != null) {
            result += "->" + node.toString();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof LinkedList<?>) {
            LinkedList<?> otherList = (LinkedList<?>) obj;
            Node<T> node = head;
            Node<?> otherNode = otherList.head;
            if (Objects.equals(node, otherNode) == false) return false;
            while (((node = node.next) != null) | ((otherNode = otherNode.next) != null)) {
                if (Objects.equals(node, otherNode) == false) return false;
            }
            return true;
        } else return false;
    }

    public int size() {
        int len = 0;
        Node<T> node = head;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }

    public T getNthToLastItem(int n) {
        // marks current node
        Node<T> current = head;
        // marks n nodes ahead
        Node<T> last = head;

        // move last pointer n steps ahead
        for (int i = 1; i < n; i++) {
            last = last.next;
        }

        // while last isnt actually last
        while (last.next != null) {
            last = last.next;
            current = current.next;
        }

        return current.data;
    }

    public T getItem(int position) {
        if (position < 0) throw new IndexOutOfBoundsException(String.valueOf(position));
        Node<T> item = head;
        for (int i = 0; i < position; i++) {
            if (item == null) throw new IndexOutOfBoundsException(String.valueOf(position));
            item = item.next;
        }
        if (item == null) throw new IndexOutOfBoundsException(String.valueOf(position));
        return item.getData();
    }

    public void removeDuplicates() {
        Node<T> node = head;
        while (node != null) {
            Node<T> next = node.next;
            Node<T> prev = node;
            while (next != null) {
                if (Objects.equals(node, next)) prev.next = next.next;
                else prev = next;

                next = next.next;
            }

            node = node.next;
        }
    }

    /**
     * Remove specified node from the list
     */
    public void deleteNode(Node<T> delete) {
        if (delete == null) throw new NullPointerException();
        if (delete.next != null) {
            delete.data = delete.next.data;
            delete.next = delete.next.next;
            return;
        }

        if (delete == head) {
            head = delete.next;
        } else {
            Node<T> node = head;
            do {
                if (node == null) return;
                if (node.next == delete) {
                    node.next = delete.next;
                    return;
                }
            } while ((node = node.next) != null);
        }
    }

    /**
     * Perform arithmetic addition against another list
     * where each item is a digit.
     * Mutates this list to become the result
     *
     * @return this
     */
    public LinkedList<T> arithmeticAdd(LinkedList<Integer> otherList) {
        Node<Integer> thisNode = (Node<Integer>) this.head;
        Node<Integer> otherNode = otherList.head;
        int overflow = 0;

        do {
            thisNode.data += overflow + otherNode.data;
            overflow = thisNode.data / 10;
            thisNode.data %= 10;
            otherNode = otherNode.next;
            if (otherNode != null && thisNode.next == null) {
                // if this list is too short, add new digit at the end
                thisNode.next = new Node<Integer>(0);
            }
            thisNode = thisNode.next;
        } while (otherNode != null || overflow > 0);

        return this;
    }

    public Node<T> getLastNode() {
        if (head == null) return null;
        Node<T> node = head;
        while (node.next != null) node = node.next;
        return node;
    }

    /**
     * Finds loop in the linked list and returns first node in the loop
     */
    public Node<T> getBeginningOfLoop() {
        Set<Node<T>> visitedNodes = new HashSet<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            if (visitedNodes.contains(node)) return node;
            visitedNodes.add(node);
            node = node.next;
        }
        return null;
    }

    /**
     * Finds loop in the linked list and returns first node in the loop
     * More efficient implementation
     *
     * This implementation uses two iterators, n1 visits nodes one by one, while n2 skips every other node.
     * Once the two iterators meet, n1 is sent back to the beginning of the list and both iterators are re-started
     * going at the same pace of one-by-one. The node where they meet is the start of the loop.
     */
    public Node<T> getBeginningOfLoop2() {
        Node<T> n1 = head;
        Node<T> n2 = head;
        while (n2 != null) {
            n1 = n1.next;
            if (n2.next == null) return null;
            n2 = n2.next.next;

            if (n2 == n1) break;
        }

        if (n2 == null) return null;

        n1 = head;

        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }

        return n1;
    }
}
