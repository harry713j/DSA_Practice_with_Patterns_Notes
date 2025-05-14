package stack.impl;

public class StackUsingLinkedList<T> {
    // so we are going to add and remove elements at the head,
    // and with linked list the size of stack is unlimited(depend on memory)
    // Using Singly Linked List
    private Node<T> head;
    private int size;

    public StackUsingLinkedList(){
        this.size = 0;
        this.head = null;
    }

    public void push(T data){
        try {
            // if we object creation unsuccessful then we will throw StackOverFlowException
            Node<T> newNode = new Node<>(data);
            if (head != null){
                newNode.next = head;
            }
            head = newNode;
            size++;
        } catch (OutOfMemoryError e) {
            throw new StackOverflowException();
        }
    }

    public T pop(){
        if (head == null){
            throw new StackUnderflowException();
        }

        Node<T> toRemove = head;
        head = head.next;
        size--;
        return toRemove.data;
    }

    public T peek(int position){
        // Position is in between 0 and (size - 1)
        if (position < 0 || position >= size){
            throw new IndexOutOfBoundsException("Can't access Stack element at that position");
        }

        Node<T> pointer = head;

        for (int i = 0; i < position; i++) {
            pointer = pointer.next;
        }

        return pointer.data;
    }

    public boolean isEmpty(){
        return head == null;
    }


    public void display(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder toDisplay = new StringBuilder();
        toDisplay.append("[");

        Node<T> pointer = head;

        while (pointer != null){
            if (pointer.next == null){
                toDisplay.append(pointer.data);
            } else {
                toDisplay.append(pointer.data).append(", ");
            }
            pointer = pointer.next;
        }

        toDisplay.append("]");

        return toDisplay.toString();
    }

    private static class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
