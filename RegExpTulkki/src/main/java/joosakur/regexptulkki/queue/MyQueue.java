package joosakur.regexptulkki.queue;

public class MyQueue<T> implements Queue<T> {

    T[] queue;

    private int capacity = 10;
    private int head = 0;
    private int tail = 0;
    
    public MyQueue() {
        queue = (T[]) new Object[capacity];
    }
    
    @Override
    public boolean isEmpty() {
        return head==tail;
    }

    @Override
    public boolean offer(T item) {
        boolean full = isFull();
        queue[tail] = item;
        tail = (tail + 1) % capacity;
        if(full) increaseSize();
        return true;
    }

    @Override
    public T peek() {
        if(!isEmpty())
            return queue[head];
        else return null;
    }

    @Override
    public T poll() {
        T item = null;
        
        if(!isEmpty()){
            item = queue[head];
            head = (head + 1) % capacity;
        }
            
        return item;
    }
    
    private boolean isFull() {
        int nextTail = (tail + 1) % capacity;
        return nextTail == head;
    }

    private void increaseSize() {
        T[] queue2 = (T[]) new Object[capacity*2];
        for (int i = 0; i < capacity; i++) {
            queue2[i] = queue[(head+i)%capacity];
        }
        head = 0;
        tail = capacity;
        capacity *= 2;
        queue = queue2;
    }
}
