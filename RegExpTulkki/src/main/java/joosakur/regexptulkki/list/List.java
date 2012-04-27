package joosakur.regexptulkki.list;

public interface List<T> {
    boolean add(T item);
    T get(int index);
    boolean isEmpty();
    int size();

}
