public class QuickSorting {

    public static void sort(Comparable[] a) {
        shuffle(a);
        sortSubarray(a, 0, a.length - 1);
    }

    public static void sortSubarray(Comparable[] a, int lo, int hi) {
        if (lo - hi >= 0 && lo - hi <= 10) {
            insertionSort(a, lo, hi);
            return;
        }

        int median = medianOfThree(a, lo, hi);
        exchange(a, lo, median);

        int j = partition(a, lo, hi);
        sortSubarray(a, lo, j - 1);
        sortSubarray(a, j + 1, hi);
    }

    public static void insertionSort(Comparable[] a, int lo, int hi) {        //performs insertion sorting on the sub-array a[lo] to a[hi]
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > lo; j--) {
                if (less(a[j], a[j - 1])) {
                    exchange(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (lessOrEqual(a[++i], a[lo])) {
                if (i >= hi)
                    break;
            }
            while (lessOrEqual(a[lo], a[--j])) {
                if (j <= lo) {
                    break;
                }
            }
            if (i >= j)
                break;
            exchange(a, i, j);
        }

        exchange(a, lo, j);
        return j;
    }

    public static int medianOfThree(Comparable[] a, int lo, int hi) {
        if (hi - lo < 2) {
            return lo;
        }

        int r1 = randomNumGenerator(lo, hi);
        int r2 = randomNumGenerator(lo, hi);
        while (r2 == r1) {
            r2 = randomNumGenerator(lo, hi);
        }
        int r3 = randomNumGenerator(lo, hi);
        while (r3 == r2 || r3 == r1) {
            r3 = randomNumGenerator(lo, hi);
        }
        int median;

        if ((a[r1].compareTo(a[r2]) <= 0 && a[r2].compareTo(a[r3]) <= 0) ||
                (a[r3].compareTo(a[r2]) <= 0 && a[r2].compareTo(a[r1]) <= 0)) {
            median = r2;
        } else if ((a[r1].compareTo(a[r3]) <= 0 && a[r3].compareTo(a[r2]) <= 0) ||
                (a[r2].compareTo(a[r3]) <= 0 && a[r3].compareTo(a[r1]) <= 0)) {
            median = r3;
        } else {
            median = r1;
        }

        return median;
    }

    public static int randomNumGenerator(int lo, int hi) {
        int random = (int) (Math.random() * (hi + 1));
        while (random < lo) {
            random = (int) (Math.random() * (hi + 1));
        }
        return random;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static boolean lessOrEqual(Comparable a, Comparable b) {
        return a.compareTo(b) <= 0;
    }

    public static void exchange(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void shuffle(Comparable[] a) {                              //shuffles a using the Knuth shuffle algorithm
        for (int i = 0; i < a.length; i++) {
            int r = (int) (Math.random() * (i + 1));
            exchange(a, i, r);
        }
    }

    public static void main(String[] args) {
        String[] array = {"D", "A", "E", "C", "B", "A", "X", "C", "B", "A", "X", "C", "B", "Z", "B"};
        sort(array);
        for (String s : array) {
            System.out.println(s);
        }

    }
}


