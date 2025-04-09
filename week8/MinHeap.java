import java.lang.reflect.Array;
import java.util.Arrays;

public class MinHeap<Key extends Comparable<Key>> {

    private Key[] pq;
    private int N;

    public MinHeap(int capacity) {
        N = 0;
        pq = (Key[]) (new Comparable[capacity]);
    }

    public void insert(Key x) {
        pq[++N] = x;
        swim(N);
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exchange(k, k / 2);
            k = k / 2;
        }
    }

    private boolean greater(int i, int j) {
        return pq[i].compareTo(pq[j]) > 0;
    }

    private void exchange(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public Key delMin() {
        Key item = pq[1];
        exchange(1, N--);
        sink(1);
        pq[N + 1] = null;
        return item;
    }

    private void sink(int k) {
        while (k * 2 <= N) {
            int j = k * 2; // Filho da esquerda
            if (j < N && greater(j, j + 1)) {
                j++; // Passa a ser o filho da direita
            }

            if (greater(j, k)) {
                break;
            }

            exchange(k, j);
            k = j;
        }
    }

    public static void print(Comparable[] arr) {
        TreePrinter<Integer> printer = new TreePrinter<>(k -> "" + arr[k],
                k -> 2 * k < arr.length ? 2 * k : null,
                k -> 2 * k + 1 < arr.length ? 2 * k + 1 : null);
        printer.setHspace(2); //espaço horizontal entre nós
        printer.setSquareBranches(true);
        printer.printTree(1); //1 = root
    }

    @Override
    public String toString() {
        return "MinHeap{" +
                "pq=" + Arrays.toString(pq) +
                ", N=" + N +
                '}';
    }

    public static void main(String[] args) {
        MinHeap<String> a = new MinHeap<>(7);
        a.insert("B");
        a.insert("D");
        a.insert("C");
        a.insert("D");
        a.insert("E");

        System.out.println(a);
        print(a.pq);

        a.delMin();

        print(a.pq);

    }
}
