public class Stack {
    private Node first;
    private int size;
    public Stack() {
        first = null;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;

        size++;
    }

    public String pop() {
        return "";
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return size;
    }

    private class Node {
        public String item;
        public Node next;
    }


}
