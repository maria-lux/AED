public class OrderedList_Arr<T extends Comparable<T>> {

    private T[] list;
    private int first;
    private int last;

    public OrderedList_Arr() {
        list = (T[]) new Comparable[5]; //Ugly cast
        first = -1;
        last = -1;
    }

    public void add(T item) {
        if (last == list.length - 1) {
            throw new IllegalStateException("Overflow"); //resize
        }
        if (first == -1) {
            first++;
        }
        list[++last] = item; // last = next(last); list[last] = item;
    }

    public void sort() {
        for (int i = 0; i < list.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(list[j], list[j - 1])) {
                    exchange(j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private void exchange(int a, int b) {
        T temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }

    public boolean isSorted() {
        for (int i = 1; i < list.length; i++) {
            if (less(list[i], list[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public void shuffle() {
        for (int i = 0; i < list.length; i++) {
            int r = (int) (Math.random() * (i + 1));
            exchange(i, r);
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < list.length; i++) {
            s += list[i] + " ";
        }
        return s;
    }

    //    public boolean contains(T item)     does the list contain item?
    //    public int size()                   number of elements in the list
    //    public boolean isEmpty()            is the list empty?
    //    public Iterator<T> iterator()       return the iterator for the list

    public static void main(String[] args) {
        OrderedList_Arr<String> ls = new OrderedList_Arr<>();
        ls.add("A");
        ls.add("B");
        ls.add("C");
        ls.add("D");
        ls.add("E");
        System.out.println(ls);
        ls.shuffle();
        System.out.println(ls);
        ls.sort();
        System.out.println(ls);
        ls.shuffle();
        System.out.println(ls);
        System.out.println(ls.isSorted());
    }

}
