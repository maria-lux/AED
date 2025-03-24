import java.util.Iterator;

public class List<T> implements Iterable<T> {

    private int size;
    private Node first;
    private Node last;

    public List() {
        first = null;
        last = null;
    }

    public void add(T item) {
        Node node = new Node();
        node.item = item;

        if (first == null) {
            first = node;
        } else {
            node.previous = last;
            last.next = node;
        }
        last = node;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Invalid index");
        }

        int counter = 0;
        Node current = first;

        while (counter <= index) {
            if (counter == index) {
                return current.item;
            }
            counter++;
            current = current.next;
        }

        return null;
    }

    public T remove(int index) {
        Node current = first;
        int counter = 0;

        if (index == 0) {
            first = current.next;
            first.previous = null;
            size--;
            return current.item;
        }

        if (index == size - 1) {
            current = last;
            last = current.previous;
            last.next = null;
            size--;
            return current.item;
        }

        while (counter <= index) {
            if (counter == index) {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                size--;
            }
            counter++;
            current = current.next;
        }
        return current.item;
    }


    public boolean removeFirst(T item) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.item.equals(item)) {
                remove(index);
                return true;
            }
            current = current.next;
            index++;
        }
        return false;
    }

    public boolean removeLast(T item) {
        Node current = last;
        int index = size - 1;

        while (current != null) {
            if (current.item.equals(item)) {
                remove(index);
                return true;
            }
            current = last.previous;
            index--;
        }
        return false;
    }

    public boolean removeAll(T item) {
        Node current = first;
        boolean result = false;
        int index = 0;

        while (current != null) {
            if (current.item.equals(item)) {
                remove(index);
                result = true;
            } else {
                index++;
            }
            current = current.next;
        }

        return result;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public boolean contains(T item) {
        Node current = first;
        while (current != null) {
            if (current.item.equals(item)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isPalindrome() {
        int a = 0;
        int b = size - 1;
        while (a < b) {
            System.out.println("INDEX A: " + a + ", INDEX B: " + b);
            if (!get(a).equals(get(b))) {
                return false;
            }
            a++;
            b--;
        }
        return true;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    private class Node {
        public T item;
        public Node next;
        public Node previous;
    }

    private class MyListIterator implements Iterator<T> {
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

    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }

    public static void main(String[] args) {
        List<String> list = new List<>();
        list.add("A");
        System.out.println(list.isPalindrome());

    }
}
