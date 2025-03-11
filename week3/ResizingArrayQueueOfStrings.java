import java.util.Arrays;

public class ResizingArrayQueueOfStrings {

    /* two pointers: first and last
        move pointers to enqueue and dequeue
     */
    private String[] queue;
    int first;
    int last;
    // TODO array should be resizeable
    //private int N;

    public ResizingArrayQueueOfStrings() {
        queue = new String[1];
        first = -1; //indicating that array is empty
        last = -1;
    }

    public void enqueue(String item) {
        //array is full - resize array/double array length
        if (next(last) == first) {
            resize(queue.length * 2);
        }

        last = next(last);
        queue[last] = item;

        if (first == -1) {
            first = 0;
        }
    }

    // TODO resize() --> double queue length --> copy values using two pointers (first in arr[0])
    public void resize(int length) {
        String[] tempQueue = new String[length];
        int size = size();
        int index = first;

        for (int i = 0; i < size; i++) {
            tempQueue[i] = queue[index];
            index = next(index);
        }

        queue = tempQueue;
        first = 0;
        last = size - 1;
    }

    private int next(int index) {
        return (index + 1) % queue.length;
    }

    public String dequeue() {
        if (first == -1) {
            throw new IllegalStateException("Underflow");
        }
        String item = queue[first];
        queue[first] = null;

        if (first == last) {
            first = -1;
            last = -1;
        } else {
            first = next(first);
        }

        // TODO if() {regra matematica} resize() 25%
        if (this.size() > 0 && this.size() == queue.length / 4) {
            resize(queue.length / 2);
        }

        return item;
    }

    public boolean isEmpty() {
        return first == -1;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        if (first < last) {
            return last - first + 1;
        }
        return queue.length - first + last + 1;
    }

    public void shift() {
        String[] tempQueue = new String[queue.length];
        int size = size();
        int index = first;

        tempQueue[0] = queue[last];

        for (int i = 1; i < size; i++) {
            tempQueue[i] = queue[index];
            index = next(index);
        }
        queue = tempQueue;
        first = 0;
        last = size - 1;
    }

    public int getFirst() {
        return first;
    }

    public int getLast() {
        return last;
    }

    @Override
    public String toString() {
        return "ResizingArrayQueueOfStrings{" +
                "queue=" + Arrays.toString(queue) +
                '}';
    }

    public static void main(String[] args) {

    }

}
