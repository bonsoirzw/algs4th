package chapter2;

public class Insertion extends Sort {

    @Override
    public void sort(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && less(array[j], array[j-1]); j--){
                exchange(array,j,j-1);
            }
        }
    }

    public static void main(String[] args) {
       test(new Insertion());
    }
}
