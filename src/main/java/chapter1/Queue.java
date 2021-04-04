package chapter1;

import java.util.Iterator;
import java.util.stream.IntStream;

public class Queue <T>  implements api.chapter1.Queue<T> ,Iterable<T>{

    private Node head;

    private Node tail;

    private int N;


    public Queue() {
        N = 0;
        head = new Node(0);
        tail = head;
    }

    @Override
    public int size(){
        return this.N;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public void enqueue(T val) {
       Node node = new Node(val);
       tail.next = node;
       tail = node;
       this.N++;
    }

    @Override
    public T dequeue() {
        if(!isEmpty()){
            Node node = head;
            head = head.next;
            this.N--;
            return (T)node.next.val;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class ListIterator implements Iterator<T> {

        private Node first = head;

        @Override
        public boolean hasNext() {
            return first != null;
        }

        @Override
        public T next() {
            Node tmp = first;
            first = first.next;
            return (T) tmp.val;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        System.out.println(queue.isEmpty());
        IntStream.rangeClosed(1,10).forEach(queue::enqueue);
        while (!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
    }
}
