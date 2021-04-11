package chapter2;

public class MaxPQ<T extends Comparable<T>> {

    private T[] pq;

    private int N = 0;

    public MaxPQ(int size) {
        pq = (T []) new Comparable[size + 1];

    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exec(int i, int j) {
        T tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exec(k / 2, k);
            k /= 2;
        }
    }

    private void sink(int k){
       while (2 * k <= N){
           int j = 2 * k;
           if(j < N && less(j,j+1)) j++;
           if(less(j,k)) break;
           exec(j,k);
           k = j;
       }
    }

    public int size(){
        return N;
    }

    public void insert(T key){
        pq[++N] = key;
        swim(N);
    }

    public T delMax(){
        T tmp = pq[1];
        exec(1,N--);
        sink(1);
        return tmp;
    }
}
