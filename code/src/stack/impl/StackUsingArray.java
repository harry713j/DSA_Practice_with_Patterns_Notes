package stack.impl;

public class StackUsingArray<T> {
    private int size;
    private int top;
    private Object[] elements;

    public StackUsingArray(){
        this.size = 10;
        this.top = -1;
        this.elements = new Object[this.size];
    }

    public StackUsingArray(int capacity){
        this.size = capacity;
        this.top = -1;
        this.elements = new Object[this.size];
    }

    public void push(T data){
        // putting elements to the stack
        if (top + 1 == size){
            throw new StackOverflowException();
        }
        top++;
        elements[top] = data;
    }

    public T pop(){
        // remove the elements from the stack
        if (top == -1){
            throw new StackUnderflowException();
        }
       return (T) elements[top--];
    }

    public T peek(int position){
        // position starts from 0 till (size - 1)
        if (position < 0 || position > top){
            throw new IndexOutOfBoundsException("Can't access Stack element at that position");
        }

        return (T) elements[top - position];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top + 1 == size;
    }

    public void display(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder toDisplay = new StringBuilder();
        toDisplay.append("[");
         int i = top;

         while (i >= 0){
             if (i == 0){
                 toDisplay.append((T) elements[i]);
             } else {
                 toDisplay.append((T) elements[i]).append(", ");
             }
             i--;
         }
         toDisplay.append("]");

         return toDisplay.toString();
    }
}
