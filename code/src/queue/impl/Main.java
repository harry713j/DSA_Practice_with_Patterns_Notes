package queue.impl;

public class Main {
    public static void main(String[] args) {
//        QueueUsingArray<Integer> qua = new QueueUsingArray<>();
//        for (int i = 0; i < 10; i++) {
//            qua.add(i + 1);
//        }
//        System.out.println(qua.toString());
//        qua.add(11);
//        System.out.println(qua.toString());
//        System.out.println(qua.remove());
//        System.out.println(qua.remove());
//        System.out.println(qua.remove());
//        System.out.println(qua.peek());
//        System.out.println(qua.toString());

//        CircularQueueUsingArray<Integer> cqua = new CircularQueueUsingArray<>();
//        for (int i = 0; i < 9; i++) {
//            cqua.add(i + 1);
//        }
//
//        System.out.println(cqua);
////        cqua.add(11);
//        System.out.println(cqua);
//        System.out.println(cqua.remove());
//        System.out.println(cqua.remove());
//        System.out.println(cqua.remove());
//
//        System.out.println(cqua.toString());
//        System.out.println(cqua.size());

        QueueUsingLinkedList<Integer> qull = new QueueUsingLinkedList<>();
        for (int i = 0; i < 5; i++) {
            qull.add(i + 1);
        }

        System.out.println(qull);
//        cqua.add(11);
        System.out.println(qull);
        System.out.println(qull.remove());
        System.out.println(qull.remove());
        System.out.println(qull.remove());

        System.out.println(qull.toString());
        System.out.println(qull.size());
    }
}
