package chapter2;

public class Merge extends Sort {


    private Comparable[] tmp;

    private void merge(Comparable[] array, int lo, int mid, int hi){
        int i = lo,j = mid + 1;
        for (int k = lo; k <= hi; k++){
            tmp[k] = array[k];
        }
        for (int k = lo; k <= hi; k++){
            if(i > mid) array[k] = tmp[j++];
            else if(j > hi) array[k] = tmp[i++];
            else if(less(tmp[i],tmp[j])) array[k] = tmp[i++];
            else array[k] = tmp[j++];
        }
    }

    private void sort(Comparable[] array,int lo,int hi){
        if(lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(array,lo,mid);
        sort(array,mid + 1,hi);
        merge(array,lo,mid,hi);
    }

    @Override
    public void sort(Comparable[] array) {
        tmp = new Comparable[array.length];
        sort(array,0,array.length - 1);
    }

    public static void main(String[] args) {
        test(new Merge());
    }
}
