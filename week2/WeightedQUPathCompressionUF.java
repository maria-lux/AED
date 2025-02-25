import java.util.Arrays;

public class WeightedQUPathCompressionUF {

    private int[] id;
    private int[] size;

    public WeightedQUPathCompressionUF(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("Valor de N inválido");
        }
        id = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int root(int p) {
        while (id[p] != p) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        if (connected(p, q)) {
            return;
        }

        int i = root(p);
        int j = root(q);

        if (size[i] < size[j]) {
            id[j] = i;
            size[i] += size[j];
        } else {
            id[i] = j;
            size[j] += size[i];
        }
    }

    @Override
    public String toString() {
        return "WeightedQUPathCompressionUF{" +
                "id=" + Arrays.toString(id) +
                ", size=" + Arrays.toString(size) +
                '}';
    }

    public static void main(String[] args) {
        WeightedQUPathCompressionUF wqu = new WeightedQUPathCompressionUF(8);

    }
}
