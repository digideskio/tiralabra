package joosakur.regexptulkki.list;

import java.util.ArrayList;

public class JavaList<T> implements List<T> {

    private java.util.List<T> list;

    public JavaList() {
        list = new ArrayList<T>();
    }
    
     
    @Override
    public boolean add(T item) {
        return list.add(item);
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean addAll(List<T> items) {
        for (int i = 0; i < items.size(); i++) {
            this.add(items.get(i));
        }
        return true;
    }
    
}
