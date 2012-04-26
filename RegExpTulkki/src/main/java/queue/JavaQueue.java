package queue;

import java.util.LinkedList;

public class JavaQueue<T> implements Queue<T> {

    private java.util.Queue<T> queue;

    public JavaQueue() {
        queue = new LinkedList<T>();
    }
    
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean offer(T item) {
        return queue.offer(item);
    }

    @Override
    public T peek() {
        return queue.peek();
    }

    @Override
    public T poll() {
        return queue.poll();
    }
    
}
