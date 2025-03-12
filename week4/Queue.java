import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

    //public Queue()                           constructor
    //public void enqueue(T item)              add item to the queue
    //public T dequeue()                       remove and return the least recently added item
    //public boolean isEmpty()                 is the queue empty?
    //public int size()                        number of items in the queue
    //public void shift()		         move the last element to the start of the queue
    private class Node {
        public T item;
        public Node next;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
