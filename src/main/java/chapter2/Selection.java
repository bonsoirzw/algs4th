package chapter2;

public class Selection extends Sort {

    @Override
    public void sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (less(array[j], array[minIndex])) minIndex = j;
            }
            exchange(array, i, minIndex);
        }
    }

    public static void main(String[] args) {
        test(new Selection());
    }
}
