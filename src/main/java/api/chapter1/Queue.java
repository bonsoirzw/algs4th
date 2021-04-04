package api.chapter1;

public interface Queue <T> {

    boolean isEmpty();

    int size();

    void enqueue(T val);

    T dequeue();
}
