package chapter1;

public class BinarySearch {


    public static int binarySearch(int key,int [] array){
        if(array == null || array.length == 0){
            return -1;
        }
        int lo = 0,hi = array.length - 1,mid;
        while (lo <= hi){
            mid = lo + (hi - lo) / 2;
            if(key == array[mid]) return mid;
            else if(array[mid] > key) hi = mid - 1;
            else lo = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
