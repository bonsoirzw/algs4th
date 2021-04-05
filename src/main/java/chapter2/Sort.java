package chapter2;

import java.security.SecureRandom;
import java.util.Arrays;

public abstract class Sort {

    /**
     * exchange array[i] array[j]
     * @param array array of Comparable
     * @param i index i
     * @param j index j
     */
    protected static void exchange(Comparable [] array,int i,int j){
        Comparable tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    /**
     *
     * @param p Comparable
     * @param q Comparable
     * @return true if p less than q
     */
    protected static  boolean less(Comparable p,Comparable q){
        return p.compareTo(q) < 0;
    }

    /**
     *
     * @param array array of Comparable
     * @return true if array is sorted
     */
    public static boolean isSorted(Comparable [] array){
        for (int i = 1; i < array.length;i++){
            if(less(array[i],array[i-1])) return false;
        }
        return true;
    }

    /**
     * print element in array
     * @param array array of Comparable
     */
    public static void show(Comparable [] array){
        Arrays.stream(array).map(e -> e + " ").forEach(System.out::print);
    }

    public abstract void sort(Comparable[] array);

    protected static Comparable[] generateArray(int len){
        SecureRandom random = new SecureRandom();
        Comparable [] array = new Integer[len];
        for (int i = 0; i < len; i++){
            array[i] = random.nextInt(8 * len);
        }
        return array;
    }

    public static void test(Sort sort){
        Comparable [] array = generateArray(10);
        System.out.println("排序前......");
        show(array);
        sort.sort(array);
        System.out.println(isSorted(array));
        System.out.println("排序后......");
        show(array);
    }


}
