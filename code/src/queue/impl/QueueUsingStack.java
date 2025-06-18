package queue.impl;

import stack.impl.StackUsingArray;

// using two stacks
public class QueueUsingStack<T> {
    private StackUsingArray<T> s1;
    private StackUsingArray<T> s2;
    private int size; // if we maintain two sizes for both the stack then we can do the toString() operation too

    public QueueUsingStack(){
        this.s1 = new StackUsingArray<>();
        this.s2 = new StackUsingArray<>();
        this.size = 0;
    }

    public void add(T data){
        if (data == null){
            throw new IllegalArgumentException("Can't add null");
        }

        s1.push(data);
        size++;
    }

    public T remove(){
        // we will move elements to second stack and then remove
        if (s2.isEmpty() && s1.isEmpty()){
            return null;
        } else if (s2.isEmpty()) {
            // move element to s1
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }

            size--;
            return s2.pop();
        } else {
            size--;
            return s2.pop();
        }
    }

    public T peek(){
        // we will move elements to second stack and then remove
        if (s2.isEmpty() && s1.isEmpty()){
            return null;
        } else if (s2.isEmpty()) {
            // move element to s1
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }

            return s2.peek(0);
        } else {
            return s2.peek(0);
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return s1.isEmpty() && s2.isEmpty();
    }
}
