package linkedlist.impl;

public class Main {
    public static void main(String[] args) {
//        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>(69);
//        sll.add(9);
//        sll.add(4);
//        sll.add(10);
//        sll.add(0, 2);
//        sll.add(3, 11);
//        sll.add(5, 11);
////        list1.clear();
//        sll.display();
//        System.out.println(sll.contains(13));
//        System.out.println(sll.get(9));
//        System.out.println(sll.indexOf(15));
//        System.out.println(sll.lastIndexOf(15));

//        sll.remove();
//        sll.remove(3);
//        sll.display();
//
//        sll.reverse();
//        sll.display();
//        CircularSinglyLinkedList<Integer> csll = new CircularSinglyLinkedList<>(69);
//        csll.add(9);
//        csll.add(4);
//        csll.add(10);
//        csll.add(0, 2);
//        csll.add(3, 11);
//        csll.add(5, 11);
////        csll.clear();
//        csll.add(99);
//        csll.display();
//        System.out.println(csll.contains(99));
//        System.out.println(csll.get(7));
//        System.out.println(csll.indexOf(99));
//        System.out.println(csll.lastIndexOf(11));
//        System.out.println(csll.remove());
//        System.out.println(csll.remove(3));
//        csll.reverse();
//        csll.display();



        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>(69);
        dll.add(9);
        dll.add(4);
        dll.add(10);
        dll.add(0, 2);
        dll.add(3, 11);
        dll.add(5, 11);
//        dll.clear();
        dll.add(99);
        dll.display();
//        System.out.println(dll.contains(99));
//        System.out.println(dll.get(dll.size() - 1));
//        System.out.println(dll.indexOf(99));
//        System.out.println(dll.lastIndexOf(11));
        System.out.println(dll.remove());
        System.out.println(dll.remove(6));
        System.out.println(dll.remove(4));
        dll.display();
        dll.reverse();
        dll.display();

    }
}
