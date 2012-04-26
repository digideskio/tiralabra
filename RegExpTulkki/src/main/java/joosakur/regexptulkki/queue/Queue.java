package joosakur.regexptulkki.queue;

public interface Queue<T> {
    boolean isEmpty();
    boolean offer(T item);
    T peek();
    T poll();
}
