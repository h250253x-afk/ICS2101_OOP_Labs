import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> head;

    public void add(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;
    }

    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> curr = head;
            public boolean hasNext() { return curr != null; }
            public T next() {
                T val = curr.data;
                curr = curr.next;
                return val;
            }
        };
    }
}
