package joosakur.regexptulkki.list;

public interface List<T> {
    boolean add(T item);
    boolean addAll(List<T> items);
    T get(int index);
    boolean isEmpty();
    int size();

}
