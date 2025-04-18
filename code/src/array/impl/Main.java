package array.impl;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(5);
        arr.add(9);
        arr.add(11);
        arr.add(7);

        MyArrayList<Integer> arr2 = new MyArrayList<>();
        arr2.add(1);
        arr2.add(2);
        arr2.add(5);
        arr2.add(9);
        arr2.add(11);
        arr2.add(7);

        System.out.println(arr.toString());
//        arr.insert(4, 10);
//        arr.rotateElements(2,true);
        System.out.println(arr2.toString());

//        arr.merge(arr);
        System.out.println(arr.equals(arr2));

    }
}
