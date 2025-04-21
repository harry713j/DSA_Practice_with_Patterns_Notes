package linkedlist.impl;

public class DoublyLinkedListWithTail<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DoublyLinkedListWithTail(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public DoublyLinkedListWithTail(T data){
        this();
        if (data == null) throw new IllegalArgumentException("Data can't be null");

        this.head = new Node<>(data);
        this.tail = head;
        size++;

    }

    public void add(T data){
        if (data == null) throw new IllegalArgumentException("Data can't be null");

        Node<T> newNode = new Node<>(data);
        // head is null
        if (head == null){
            head = newNode;
            tail = head;
        } else {
           tail.next = newNode;
           newNode.prev = tail;
           tail = newNode;
        }
        size++;
    }

    public void add(int index, T data){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Can't add to that position");
        }

        if (data == null) {
            throw new IllegalArgumentException("Can't add null data");
        }

        Node<T> newNode = new Node<>(data);
        if (head == null){
            head = newNode;
            tail = head;
        }
        else if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node<T> pointer = head;
            for (int i = 0; i < index - 1; i++) {
                pointer = pointer.next;
            }

            newNode.next = pointer.next;
            newNode.prev = pointer;
            if (pointer.next != null) {
                pointer.next.prev = newNode;
            }
            pointer.next = newNode;
        }
        size++;
    }

    public void clear(){
        head = null;
        tail = null;
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

        Node<T> pointer = tail;

        for (int i = 0; i < size; i++) {
            if (pointer.data.equals(element)){
                return i;
            }
            pointer = pointer.prev;
        }

        return -1;
    }

    public T remove(){
        if (head == null){
            return null;
        }

        Node<T> toBeARemoved = head;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        toBeARemoved.next = null;
        size--;
        return toBeARemoved.data;
    }

    public T remove(int index){
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Can't get element in that position");
        }

        Node<T> first = head;

        if (index == 0){
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            first.next = null;
            size--;
            return first.data;
        } else if (index == size - 1){
            Node<T> toBeRemoved = tail;
            tail = tail.prev;
            tail.next = null;
            toBeRemoved.prev = null;
            size--;
            return toBeRemoved.data;
        }

        Node<T> second = null;

        for (int i = 0; i < index; i++) {
            second = first;
            first = first.next;
        }

        second.next = first.next;
        first.prev = null;
        if (first.next != null){
            first.next.prev = second;
        }
        first.next = null;
        size--;
        return first.data;
    }

    public void reverse(){
        if (head == null || head.next == null){
            return;
        }

        Node<T> prev, curr, next;
        curr = head;
        prev = null;

        while (curr != null){
            next = curr.next;
            // changing the links
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }

        tail = head;
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

    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T element) {
            this.data = element;
            this.next = null;
            this.prev = null;
        }
    }
}
