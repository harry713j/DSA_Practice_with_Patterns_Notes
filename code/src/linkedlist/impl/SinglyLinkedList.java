package linkedlist.impl;

public class SinglyLinkedList<T> {
    private Node<T> head;
    private int size;

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public SinglyLinkedList(T data) {
        this();
        if (data == null) throw new IllegalArgumentException("Data cannot be null");
        this.head = new Node<>(data);
        size++;
    }

    public void add(T data) {
        if (data == null) throw new IllegalArgumentException("Data cannot be null");
        // creating the new node
        Node<T> newNode = new Node<>(data);

        // head is null
        if (head == null) {
            head = newNode;
        } else {
            // if already there is some elements
            Node<T> pointer = head;

            while (pointer.next != null) {
                pointer = pointer.next;
            }

            pointer.next = newNode;
        }
        size++;
    }

    public void add(int index, T data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Can't add element in that position");
        }

        if (data == null) {
            throw new IllegalArgumentException("Data can't be null");
        }

        Node<T> newNode = new Node<>(data);


        // index = 0 then we have to simply make head to pointing to it
         if (index == 0) {
            newNode.next = head;
            head = newNode;

        } else {
            Node<T> pointer = head;
            for (int i = 0; i < index - 1; i++) {
                pointer = pointer.next;
            }
            newNode.next = pointer.next;
            pointer.next = newNode;

        }
        size++;
    }

    public void addFirst(T data){
        if (data == null) throw new IllegalArgumentException("Data cannot be null");
        // creating the new node
        Node<T> newNode = new Node<>(data);

        // head is null
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        size++;
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public boolean contains(T element){
        if (element == null) throw new IllegalArgumentException("Can't find null");
        Node<T> pointer = head;

        while (pointer != null){
            if (pointer.data.equals(element)) {
                return true;
            }
            pointer = pointer.next;
        }
        return false;
    }

    public void display(){
        System.out.println(this.toString());
    }

    public T get(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Can't get element in that position");
        }

        Node<T> pointer = head;

        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }

        return pointer.data;
    }

    public int indexOf(T element){
        if (element == null){
            throw new IllegalArgumentException("Should be a valid value");
        }

        Node<T> pointer = head;

        for (int i = 0; i < size; i++) {
            if (pointer.data.equals(element)){
                return i;
            }
            pointer = pointer.next;
        }
        return -1;
    }

    public int lastIndexOf(T element){
        if (element == null){
            throw new IllegalArgumentException("Should be a valid value");
        }

        Node<T> pointer = head;
        int prevIndex = -1;

        // we keep putting the index of founded element and return it
        for (int i = 0; i < size; i++) {
            if (pointer.data.equals(element)){
                prevIndex = i;
            }
            pointer = pointer.next;
        }

        return prevIndex;
    }

    public T remove(){
        // remove the head element
        if (head == null){
            return null;
        }

        Node<T> toBeRemoved = head;
        head = head.next;
        toBeRemoved.next = null;
        size--;

        return toBeRemoved.data;
    }

    public T remove(int index){
        // remove element from specified index
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Can't remove elements from those index");
        }

        Node<T> first = head;

        if (index == 0){
            // we need to move the head
            head = head.next;
            first.next = null;
            size--;
            return first.data;
        }

        Node<T> second = null;

        for (int i = 0; i < index; i++) {
           second = first;
           first = first.next;
        }

        second.next = first.next;
        first.next = null;
        size--;
        return  first.data;
    }

    public void reverse(){
        if (head == null || size == 1){
            return;
        }

        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;

        while (current != null){
            next = current.next;

            // reverse the links
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        StringBuilder toDisplay = new StringBuilder();
        toDisplay.append("[");

        Node<T> pointer = head;
        while (pointer != null){
            if (pointer.next == null){
                toDisplay.append(pointer.data);
            }else {
                toDisplay.append(pointer.data).append(", ");
            }
            pointer = pointer.next;
        }

        toDisplay.append("]");

        return toDisplay.toString();
    }

    public static class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T element) {
            this.data = element;
            this.next = null;
        }
    }
}
