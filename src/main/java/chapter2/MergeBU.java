package chapter2;

import java.util.Arrays;

public class MergeBU extends Sort {

    private Comparable[] tmp;

    private void merge(Comparable[] array, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            tmp[k] = array[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) array[k] = tmp[j++];
            else if (j > hi) array[k] = tmp[i++];
            else if (less(tmp[i], tmp[j])) array[k] = tmp[i++];
            else array[k] = tmp[j++];
        }
    }

    @Override
    public void sort(Comparable[] array) {
        tmp = new Comparable[array.length];
        for (int sz = 1; sz < array.length; sz += sz) {
            for (int lo = 0; lo < array.length - sz; lo += sz + sz) {
                merge(array, lo, lo + sz - 1, Math.min(array.length - 1, lo + sz + sz - 1));
            }
        }
    }

    public static void main(String[] args) {
        test(new MergeBU());
    }
}
