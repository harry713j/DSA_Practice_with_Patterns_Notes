package stack.impl;

public class Main{
    public static void main(String[] args) {
//        StackUsingArray<Integer> sua = new StackUsingArray<>();
//        sua.push(78);
//        sua.push(19);
//        sua.push(89);
//        sua.push(66);
//        sua.push(34);
//        sua.push(56);
////        sua.push(101);
//        sua.display();
//        sua.pop();
//        sua.pop();
//        sua.pop();
//        sua.pop();
//        sua.display();
//        System.out.println(sua.peek(3));
//        System.out.println(sua.isEmpty());
//        System.out.println(sua.isFull());
//        StackUsingLinkedList<Integer> sull = new StackUsingLinkedList<>();
//        sull.push(78);
//        sull.push(19);
//        sull.push(89);
//        sull.push(66);
//        sull.push(34);
//        sull.push(56);
////        sua.push(101);
//        sull.display();
//        sull.pop();
//        sull.pop();
//        sull.pop();
//        sull.pop();
//        sull.display();
//        System.out.println(sull.peek(1));
//        System.out.println(sull.isEmpty());

        StackUsingQueue<Integer> suq = new StackUsingQueue<>();
        suq.push(78);
        suq.push(19);
        suq.push(89);
        suq.push(66);

//        sua.push(101);
        System.out.println(suq);
        suq.pop();
        suq.pop();

        System.out.println(suq);
        System.out.println(suq.peek());
        System.out.println(suq.isEmpty());
    }
}
