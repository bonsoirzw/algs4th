package chapter2;

import java.util.stream.IntStream;

public class Heap extends Sort {


    private boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private void sink(Comparable[] a, int i, int N) {
        while (2 * i <= N) {
            int j = 2 * i;
            if (j < N && less(a, j, j + 1)) j++;
            if(less(a,j,i)) break;
            exchange(a,i,j);
            i = j;
        }
    }

    @Override
    public void sort(Comparable[] array) {
        int N = array.length - 1;
        for(int i = N / 2; i >= 1; i--){
            sink(array,i,N);
        }
        //只能排序 1 到 N的元素
        array[0] = 0;
        while (N > 1){
            exchange(array,1,N--);
            sink(array,1,N);
        }

    }

    public static void main(String[] args) {
       test(new Heap());
    }
}
