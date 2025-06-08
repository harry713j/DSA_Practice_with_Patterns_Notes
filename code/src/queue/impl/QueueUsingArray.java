package queue.impl;

public class QueueUsingArray<T> {
    private Object[] elements;
    private int front;
    private int rear;
    private int capacity;

    public QueueUsingArray(){
        this.capacity = 10;
        this.elements = new Object[this.capacity];
        this.front = 0;
        this.rear = 0;
    }

    public void add(T element){
        if (element == null){
            throw new IllegalArgumentException("Element can't be null");
        }
        // if the capacity is full resize
        if (rear - front == capacity){
            capacity = 2 * capacity;
            Object[] newElements = new Object[capacity];
            for (int i = 0; i < elements.length; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        elements[rear] = element;
        rear++;
    }

    public int size(){
        return rear - front;
    }

    public Boolean isEmpty(){
        return rear - front == 0;
    }

    public T peek(){
        if (rear - front == 0){
            return null;
        }


        return (T) elements[front];
    }

    public T remove(){
        if (this.isEmpty()){
            return null;
        }

        T removed = (T) elements[front];
        // shift the elements to the front
        for (int i = 0; i < rear - front - 1; i++) {
            elements[i] = elements[i + 1];
        }
        rear--;
        return removed;
    }

    @Override
    public String toString() {
        StringBuilder display = new StringBuilder();
        display.append("[");

        for (int i = 0; i < rear - front; i++) {
            if (i == rear - front - 1){
                display.append(elements[i]);
            } else {
                display.append(elements[i]).append(", ");
            }
        }
        display.append("]");

        return display.toString();
    }
}
