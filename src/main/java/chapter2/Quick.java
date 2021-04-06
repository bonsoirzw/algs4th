package chapter2;

public class Quick extends Sort{


    private int partition(Comparable[] array,int lo,int hi){
        Comparable v = array[lo];
        int i = lo,j = hi + 1;
        while (lo <= hi){
            while (less(array[++i],v)) if(i == hi) break;
            while (less(v,array[--j])) if(j == lo) break;
            if(i >= j) break;
            exchange(array,i,j);
        }
        exchange(array,lo,j);
        return j;
    }

    public void sort(Comparable [] array,int i,int j){
        if(i >= j) return;
        int mid = partition(array,i,j);
        sort(array,i,mid - 1);
        sort(array,mid + 1,j);
    }


    @Override
    public void sort(Comparable[] array) {
        sort(array,0,array.length - 1);
    }

    public static void main(String[] args) {
        test(new Quick());
    }
}
