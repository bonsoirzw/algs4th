package chapter1;

import java.util.Iterator;
import java.util.stream.IntStream;

public class Stack<T> implements api.chapter1.Stack<T>{

    /**
     * 头节点
     */
    private Node head;

    /**
     * 节点数
     */
    private int size;

    public Stack() {
        this.size = 0;
    }

    @Override
    public void push(T item) {
        if (head == null) head = new Node();
        Node temp = head;
        Node curhead = new Node(item);
        curhead.next = temp;
        head = curhead;
        size++;
    }

    @Override
    public T pop() {
        Node temp = head;
        T val = (T)temp.val;
        head = temp.next;
        temp = null;
        size--;
        return val;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }



    private class Node<T>{
        T val;
        Node next;

        public Node(T val) {
            this.val = val;
        }

        public Node() {
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        IntStream.rangeClosed(1,10).forEach(stack::push);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
