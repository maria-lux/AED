import java.util.Arrays;

public class QuickUnionUF {

    // diff interpretation: the id[i] is parent of i
    private int[] id;

    public QuickUnionUF(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    //identificar a raiz
    public int root(int p) {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }
        return root;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        id[p] = root(q);
    }

    @Override
    public String toString() {
        return "QuickUnionUF{" +
                "id=" + Arrays.toString(id) +
                '}';
    }

    public static void main(String[] args) {
        QuickUnionUF qu = new QuickUnionUF(5);
        qu.union(0, 1);
        qu.union(4, 1);
        System.out.println(qu.connected(0, 1));
        System.out.println(qu);
    }
}
