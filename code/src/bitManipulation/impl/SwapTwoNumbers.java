package bitManipulation.impl;

public class SwapTwoNumbers {

    public static void main(String[] args) {
        // imp: swap two number:
        int a = 7, b = 13;
        System.out.println("a=" + a + " b=" + b);
        // method-1: (using a third variable)
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Method - 1");
        System.out.println("a=" + a + " b=" + b);

        a = 7;
        b = 13;
        //method-2: (math)
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("Method - 2");
        System.out.println("a=" + a + " b=" + b);

        a = 7;
        b = 13;
        // method-3: (XOR)
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("Method - 3");
        System.out.println("a=" + a + " b=" + b);
    }
}
