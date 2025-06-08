package queue.impl;

// Double ended queue
public class DequeUsingLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public DequeUsingLinkedList(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void addFirst(T data){
        if (data == null){
            throw new IllegalArgumentException("Can't add Null");
        }

        try {
            Node<T> newNode = new Node<>(data);

            if (head == null){
                head = newNode;
                tail = head;
            } else {
                newNode.next = head;
                head = newNode;
            }

            size++;

        } catch (Exception e){
            throw new RuntimeException("Deque is Full");
        }
    }

    public void addLast(T data){
        if (data == null){
            throw new IllegalArgumentException("Can't add Null");
        }

        try {
            Node<T> newNode = new Node<>(data);

            if (head == null){
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            size++;

        } catch (Exception e){
            throw new RuntimeException("Deque is Full");
        }
    }

    public Boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return size;
    }

    public T removeFirst(){
        if (isEmpty()){
            return null;
        }

        T removed = head.value;
        head = head.next;

        if (head == null){
            tail = null;
        }

        size--;

        return removed;
    }

    public T removeLast(){
        if (isEmpty()){
            return null;
        }

        Node<T> prev = null;
        Node<T> removed = head;

        while (removed.next != null){
            prev = removed;
            removed = removed.next;
        }

        if (prev != null){
            prev.next = null;
        }

        tail = prev;

        if (tail == null){
            head = null;
        }

        size--;

        return removed.value;
    }

    public T peekFirst(){
        if (isEmpty())
            return null;

        return head.value;
    }

    public T peekLast(){
        if (isEmpty())
            return null;

        return tail.value;
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
