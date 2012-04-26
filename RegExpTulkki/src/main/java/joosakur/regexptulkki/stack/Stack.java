package joosakur.regexptulkki.stack;

public interface Stack<T>{
    boolean isEmpty();
    T peek();
    T pop();
    T push(T item);
}
