package stack.impl;

public class StackUnderflowException extends RuntimeException{
    public StackUnderflowException(){
        super("Stack is empty can't pop out elements");
    }
}
