import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private Node first;
    private int size;

    public Stack() {
        first = null;
    }

    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;

        size++;
    }

    public T pop() {
        if (first == null) {
            throw new IllegalStateException("Underflow");
        }
        T item = first.item;
        first = first.next;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class Node {
        public T item;
        public Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "item='" + item + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

    private class StackIterator implements Iterator<T> {

        Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        for (String s : stack) {
            System.out.println(s);
        }
    }
}
