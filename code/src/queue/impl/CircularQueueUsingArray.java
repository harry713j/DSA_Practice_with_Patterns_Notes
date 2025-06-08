package queue.impl;

public class CircularQueueUsingArray<T> {
    private Object[] elements;
    private int front;
    private int rear;
    private final int capacity = 10;

    public CircularQueueUsingArray(){
        this.elements = new Object[this.capacity];
        this.front = 0;
        this.rear = 0;
    }

    public void add(T element){
        // 1. when the queue is empty in-front of front pointer
        // 2. when the queue is empty behind the front pointer
        if (element == null){
            throw new IllegalArgumentException("Element can't be null");
        }

        // conditions for queue to be full
        if ((rear + 1) % capacity == front){
            throw new RuntimeException("Can't add element, Queue is full");
        } else {
            rear = (rear + 1) % capacity;
            elements[rear] = element;
        }
    }

    public T remove(){
        if (isEmpty()){
            return null;
        }

        front = (front + 1) % capacity;

        return (T) elements[front];
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return (T) elements[(front + 1) % capacity];
    }

    public boolean isEmpty(){
        return front % capacity == rear % capacity;
    }

    public int size(){
        if (rear > front)
            return rear - front;
        else
            return elements.length - front + rear;
    }

    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();
        display.append("[");

        if (!isEmpty()){
            int current = (front + 1) % capacity;

            while (current != (rear + 1) % capacity){
                display.append(elements[current]);
                if (current != rear) {
                    display.append(", ");
                }
                current = (current + 1) % capacity;
            }
        }

        display.append("]");

        return display.toString();
    }

}
