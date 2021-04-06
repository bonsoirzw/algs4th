package chapter2;

public class Quick3Way extends Sort {


    private void sort(Comparable[] array, int lo, int hi) {
        if(lo >= hi) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = array[lo];
        while (i <= gt) {
            int cmp = array[i].compareTo(v);
            if (cmp < 0) exchange(array, i++, lt++);
            else if (cmp == 0) i++;
            else exchange(array, i, gt--);
        }
        sort(array, lo, gt - 1);
        sort(array, gt + 1, hi);
    }


    @Override
    public void sort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void main(String[] args) {
        test(new Quick3Way());
    }
}
