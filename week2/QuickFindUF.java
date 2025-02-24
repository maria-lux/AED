import java.util.Arrays;

public class QuickFindUF {

    /*
    Doubling Hypothesis T(N) = aN^b
    b vai definir a ordem de grandeza
    T(2N) / T(N) = 2^b <=> b = lg(T(2N) / T(N))

    N^1 -> linear
    N^2 -> quadratic
    N^3 -> cubic
    lg(N) -> logarithmic
     */

    private int[] id;

    public QuickFindUF(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("Valor de N inválido");
        }
        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i; // N
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q]; // 2 -> 1
    }

    public void union(int p, int q) {
        int idp = id[p];
        int idq = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == idp) {
                id[i] = idq; // 2 N + 2 -> N
            }
        }
    }

    @Override
    public String toString() {
        return "QuickFindUF{" +
                "id=" + Arrays.toString(id) +
                '}';
    }

    public static void main(String[] args) {
        QuickFindUF qf = new QuickFindUF(5);
        qf.union(2, 0);
        //qf.union(0, 3);
        System.out.println(qf.connected(2, 3));
        System.out.println(qf.connected(0, 1));
        System.out.println(qf.connected(0, 2));
        System.out.println(qf);
    }

}
