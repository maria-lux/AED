import java.util.Iterator;

public class Queue<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int size;

    public Queue() {
        first = null;
        last = null;
    }

    public void enqueue(T item) {
        Node node = new Node();
        node.item = item;

        if (first == null) {
            first = node;
        } else {
            last.next = node;
        }

        last = node;

        size++;
    }

    public T dequeue() {
        if (first == null) {
            throw new IllegalStateException("Underflow");
        }

        T item = first.item;

        if (first == last) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }

        size--;

        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void shift() {

    }

    private class Node {
        public T item;
        public Node next;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }
}
