package joosakur.regexptulkki.stack;

public class JavaStack<T> implements Stack<T> {

    private java.util.Stack<T> stack;

    public JavaStack() {
        stack = new java.util.Stack();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public T peek() {
        return stack.peek();
    }

    @Override
    public T pop() {
        return stack.pop();
    }

    @Override
    public T push(T item) {
        return stack.push(item);
    }

    @Override
    public int size() {
        return stack.size();
    }
    
    

    
}
