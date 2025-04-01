import java.util.Iterator;

public class OrderedList<T extends Comparable<T>> implements Iterable<T> {

    private Node first;
    private Node last;
    private int size;

    public OrderedList() {
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

    public void sort() {
        if (first == null || first.next == null) {
            return;
        }

        Node i = first.next;

        while (i != null) {
            Node j = i;
            while (j.previous != null) {
                if (less(j.item, j.previous.item)) {
                    exchange(j, j.previous);
                    j = j.previous;
                } else {
                    break;
                }
            }
            i = i.next;
        }
    }


    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private void exchange(Node a, Node b) {
        T item = a.item;
        a.item = b.item;
        b.item = item;
    }

    public void shuffle() {
        int counter = 0;
        while (counter < size) {
            int random = (int) (Math.random() * (counter + 1));
            exchange(get(counter), get(random));
            counter++;
        }
    }

    public Node get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Invalid index");
        }

        int counter = 0;
        Node current = first;

        while (counter <= index) {
            if (counter == index) {
                return current;
            }
            counter++;
            current = current.next;
        }
        return null;
    }

    public boolean isSorted() {
        if (first.next == null) {
            return true;
        }

        Node current = first.next;

        while (current != null) {
            if (less(current.item, current.previous.item)) {
                return false;
            }
            current = current.next;
        }
        return true;
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

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    @Override
    public Iterator<T> iterator() {
        return new OrderedListIterator();
    }

    private class OrderedListIterator implements Iterator<T> {

        Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            ;
            current = current.next;
            return item;
        }
    }

    private class Node {
        public T item;
        public Node previous;
        public Node next;

    }

    public static void main(String[] args) {
        OrderedList<String> list = new OrderedList<>();
        list.add("D");
        list.add("A");
        list.add("C");
        list.add("B");
        list.add("G");
        list.add("B");

        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.isSorted());

        list.sort();
        System.out.println("Sorted:");
        for (String s : list) {
            System.out.println(s);
        }
        System.out.println(list.isSorted());

        //System.out.println(list.get(2).item);
        list.shuffle();
        System.out.println("Shuffled:");
        for (String s : list) {
            System.out.println(s);
        }

        list.sort();
        System.out.println("Sorted:");
        for (String s : list) {
            System.out.println(s);
        }

    }
}
