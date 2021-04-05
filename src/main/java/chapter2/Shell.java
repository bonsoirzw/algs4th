package chapter2;

public class Shell extends Sort {

    @Override
    public void sort(Comparable[] array) {
        int N = array.length;
        int h = 1;
        while (h < N / 3) h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < array.length; i++) {
                for (int j = i; j >= h && less(array[j], array[j - h]); j -= h) {
                    exchange(array, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        test(new Shell());
    }
}
