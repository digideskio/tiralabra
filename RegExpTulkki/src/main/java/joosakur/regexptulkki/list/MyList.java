package joosakur.regexptulkki.list;

public class MyList<T> implements List<T> {

    T[] list;

    private int capacity = 10;
    private int head = -1;
    
    public MyList() {
        list = (T[]) new Object[capacity];
    }
    
    
    
    @Override
    public boolean add(T item) {
        head++;
        if(head == capacity) increaseSize();
        list[head] = item;
        return true;
    }

    @Override
    public T get(int index) {
        return list[index];
    }

    @Override
    public boolean isEmpty() {
        if(head<0) return true;
        else return false;
    }

    @Override
    public int size() {
        return head+1;
    }

    private void increaseSize() {
        T[] list2 = (T[]) new Object[capacity*2];
        for (int i = 0; i < capacity; i++) {
            list2[i] = list[i];
        }
        list = list2;
        capacity *= 2;
    }

    @Override
    public boolean addAll(List<T> items) {
        for (int i = 0; i < items.size(); i++) {
            this.add(items.get(i));
        }
        return true;
    }

}
