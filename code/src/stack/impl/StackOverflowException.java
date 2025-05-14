package stack.impl;

public class StackOverflowException extends RuntimeException {
    public StackOverflowException() {
        super("Stack is full can't push elements");
    }
}
