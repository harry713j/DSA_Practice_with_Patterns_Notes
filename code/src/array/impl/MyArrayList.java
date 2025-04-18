package array.impl;

import java.util.Objects;

public class MyArrayList<T> {
    private Object[] elements;
    private int size = 0;
    private int capacity;

    public MyArrayList(){
        this(10);
    }

    public MyArrayList(int initialCapacity){

        if (initialCapacity <= 0){
            throw new IllegalArgumentException("Capacity must be greater than 0");
        }

        this.capacity = initialCapacity;
        this.elements = new Object[this.capacity];
    }

    public void add(T element){
        if (this.size == this.capacity){
            this.resize();
        }

        this.elements[this.size++] = element;
    }

    public int size(){
        return this.size;
    }

    public void insert(int position, T element){
        // If the space is free the value will be inserted automatically , but if the
        //space is already taken by another element it must be moved to next
        //space in order to create space for the new insert value
        if (position < 0 || position > size){
            throw new IllegalArgumentException("Can't insert at that position");
        }

        if (this.size == this.capacity){
            resize();
        }

        for(int i = this.size ; i > position ; i--){
            this.elements[i] = this.elements[i - 1];
        }

        elements[position] = element;
        this.size++;
    }

    public T remove(int position){
        if (position < 0 || position >= this.size){
            throw new IllegalArgumentException("Can't delete at that position");
        }

        T element = (T) this.elements[position];

        for(int i = position + 1; i < this.size; i++){
            this.elements[i - 1] = this.elements[i];
        }

        this.size--;
        return element;
    }

    public T get(int position){
        if (position < 0 || position >= this.size){
            throw new IndexOutOfBoundsException("Can't access the specified position");
        }

        return (T) this.elements[position];
    }

    public boolean contains(T element){
        if (element == null){
            for (int i = 0; i < this.size; i++){
                if (this.elements[i] == null){
                    return true;
                }
            }
        } else {
            for (int i = 0; i < this.size; i++) {
                if (element.equals(this.elements[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public void reverse(){
        for (int i = 0, j = this.size - 1; i < j; i++, j--){
            Object temp = this.elements[i];
            this.elements[i] = this.elements[j];
            this.elements[j] = temp;
        }
    }

    public void clear(){
        this.capacity = 10;
        this.elements = new Object[this.capacity];
        this.size = 0;
    }

    public int indexOf(T element){
        if (element == null){
            for (int i = 0; i < this.size; i++){
                if (this.elements[i] == null){
                    return i;
                }
            }
        }
        else {
            for (int i = 0; i < this.size; i++) {
                if (element.equals(this.elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void shiftElements(int times, boolean toRight){

        if (this.size == 0){
            return;
        }

        if (toRight){
            this.rightShift(times);
        } else {
            this.leftShift(times);
        }

    }

    public void rotateElements(int times, boolean toRight){
        if (this.size == 0){
            return;
        }

        if (toRight){
            this.rotateRight(times);
        } else {
            this.rotateLeft(times);
        }
    }

    public MyArrayList<T> merge(MyArrayList<T> list){
        if (list.size == 0){
            return this.copy();
        }

        MyArrayList<T> mergedList = new MyArrayList<>(this.size + list.size);

        for (int i = 0; i < this.size; i++) {
            mergedList.add((T) this.elements[i]);
        }

        for (int i = 0; i < list.size; i++) {
            mergedList.add((T) list.elements[i]);
        }

        return mergedList;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) obj;

        if (this.size != that.size) return false;

        for (int i = 0; i < this.size; i++){
            if (!Objects.equals(this.elements[i], that.elements[i])){
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        for (int i = 0; i < this.size; i++) {
            hash = 31 * hash + (elements[i] == null ? 0 : elements[i].hashCode());
        }
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder show = new StringBuilder("[");

        for (int i = 0; i < this.size; i++){
            if (i == this.size - 1){
                show.append(this.elements[i]);
            } else {
                show.append(this.elements[i]).append(", ");
            }
        }

        show.append("]");

        return show.toString();
    }

    private void rotateRight(int k){
        k = k % this.size;
        this.reverse(this.elements, 0, this.size - k - 1);
        this.reverse(this.elements, this.size - k, this.size - 1);
        this.reverse(this.elements, 0, this.size - 1);
    }

    private void rotateLeft(int k){
        k = k % this.size;
        this.reverse(this.elements, 0, k - 1);
        this.reverse(this.elements, k, this.size - 1);
        this.reverse(this.elements, 0, this.size - 1);
    }

    private void reverse(Object[] list, int start, int end){
        while (start < end){
            Object temp = list[start];
            list[start] = list[end];
            list[end] = temp;

            start++;
            end--;
        }
    }

    private void leftShift(int times){
        for (int i = times; i < this.size; i++){
            this.elements[i - times] = this.elements[i];
        }

        this.size -= times;
    }

    private void rightShift(int times){
        for (int i = this.size - 1; i >= times; i--) {
            this.elements[i] = this.elements[i - times];
        }
        this.size -= times;
    }

    private MyArrayList<T> copy() {
        MyArrayList<T> newList = new MyArrayList<>(this.capacity);
        System.arraycopy(this.elements, 0, newList.elements, 0, this.size);
        newList.size = this.size;
        return newList;
    }

    private void resize(){
        this.capacity *= 2;

        Object[] newList = new Object[this.capacity];
        // copying old elements to new
        for(int i = 0; i < this.size; i++){
            newList[i] = this.elements[i];
        }
        this.elements = newList;
    }
}
