package stack.impl;

import queue.impl.QueueUsingArray;

public class StackUsingQueue<T> {
    private QueueUsingArray<T> queue;

    public StackUsingQueue(){
        this.queue = new QueueUsingArray<>();
    }

    public void push(T data){
        int oldSize = queue.size();

        queue.add(data);

        // reverse the elements till n-1
        for (int i = 0; i < oldSize; i++) {
            queue.add(queue.peek());
            queue.remove();
        }
    }

    public T pop(){
        return queue.remove();
    }

    public T peek(){
        return queue.peek();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
