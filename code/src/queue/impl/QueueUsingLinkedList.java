package queue.impl;

public class QueueUsingLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public QueueUsingLinkedList(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void add(T element){
        if (element == null){
            throw new IllegalArgumentException("Element can't be Null");
        }

        try {
            Node<T> newNode = new Node<>(element);

            if (head == null){
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;

        } catch (Exception e) {
            throw new RuntimeException("Queue is full");
        }
    }

    public Boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return size;
    }

    public T remove(){
        if (isEmpty()){
            return null;
        }

        T removed = head.value;
        head = head.next;
        size--;

        if (head == null){
            tail = null;
        }

        return removed;
    }

    public T peek(){
        if (isEmpty()){
            return null;
        }

        return head.value;
    }

    @Override
    public String toString() {
        StringBuilder dis = new StringBuilder();
        dis.append("[");

        Node<T> temp = head;

        while (temp != null){
            dis.append(temp.value);

            if (temp.next != null){
                dis.append(", ");
            }

            temp = temp.next;
        }
        dis.append("]");
        return dis.toString();
    }

    private static class Node<T>{
        private T value;
        private Node<T> next;

        public Node(T value){
            this.value = value;
            this.next = null;
        }
    }
}
