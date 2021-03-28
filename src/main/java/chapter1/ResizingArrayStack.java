package chapter1;

import api.chapter1.Stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

public class ResizingArrayStack <T> implements Stack<T>,Iterable<T>{

    private static final int defaultInitCapacity = 16;

    private T [] array;

    private int size;

    public ResizingArrayStack() {
        this.array = (T [])new Object[defaultInitCapacity];
        this.size = 0;
    }

    public ResizingArrayStack(int capacity) {
        this.array = (T [])new Object[capacity];
        this.size = 0;
    }

    @Override
    public void push(T item) {
        if(size >= array.length){
            resize();
        }
        array[size++] = item;
    }

    @Override
    public T pop() {
        T val = array[size--];
        array[size] = null;
        return val;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private void resize(){
        T [] arr = (T[]) new Object[array.length * 2];
        System.arraycopy(array,0,arr,0,array.length);
        Arrays.fill(array,null);
        array = arr;
    }

    private class ReverseArrayIterator implements Iterator<T>{

        private int index = size;

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public T next() {
            return array[--index];
        }
    }

    public static void main(String[] args) {

        ResizingArrayStack<Integer> stack = new ResizingArrayStack<>(5);
        IntStream.rangeClosed(1,6).forEach(stack::push);
        Iterator<Integer> iterator = stack.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
