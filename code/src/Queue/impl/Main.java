package Queue.impl;

public class Main {
    public static void main(String[] args) {
        QueueUsingArray<Integer> qua = new QueueUsingArray<>();
        for (int i = 0; i < 10; i++) {
            qua.add(i + 1);
        }
        System.out.println(qua.toString());
        qua.add(11);
        System.out.println(qua.toString());
        System.out.println(qua.remove());
        System.out.println(qua.remove());
        System.out.println(qua.remove());
        System.out.println(qua.peek());
        System.out.println(qua.toString());
    }
}
