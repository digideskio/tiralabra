package joosakur.regexptulkki.stack;

public class MyStack<T> implements Stack<T> {

    T[] stack;

    private int capacity = 10;
    private int head = -1;
    
    public MyStack() {
        stack = (T[]) new Object[capacity];
    }
    
    
    @Override
    public boolean isEmpty() {
        if(head<0) return true;
        else return false;
    }

    @Override
    public T peek() {
        return stack[head];
    }

    @Override
    public T pop() {
        T itemToPop = stack[head];
        head--;
        return itemToPop;
    }

    @Override
    public T push(T item) {
        head++;
        if(head == capacity) increaseSize();
        stack[head] = item;
        return item;
    }

    @Override
    public int size() {
        return head+1;
    }

    private void increaseSize() {
        T[] stack2 = (T[]) new Object[capacity*2];
        for (int i = 0; i < capacity; i++) {
            stack2[i] = stack[i];
        }
        stack = stack2;
        capacity *= 2;
    }
    
}
