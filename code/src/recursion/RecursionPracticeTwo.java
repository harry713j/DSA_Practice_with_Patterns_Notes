package recursion;

import java.util.Arrays;

public class RecursionPracticeTwo{

    static void printNTimes(int n){
        if (n == 0){
            return;
        }

        System.out.println(n);
        printNTimes(n - 1);
        // imp: tail recursion -> after executing all the operation it is calling the function
    }

    static void print1toN(int n){
        if (n == 0){
            return;
        }

        print1toN(n - 1); // head recursion
        System.out.println(n);
    }

    static int sumOfFirstN(int n){
        if (n == 1){
            return 1;
        }

        return n + sumOfFirstN(n - 1);
    }

    static int factorial(int n){
        if (n <= 1){
            return 1;
        }

        return n * factorial(n - 1);
    }

    static void reverseArray(int[] arr){
        reverseArray(arr, 0, arr.length - 1);
    }

    static void reverseArray(int[] arr, int f, int l){
        if (f >= l){
            return;
        }

        int temp = arr[f];
        arr[f] = arr[l];
        arr[l] = temp;
        reverseArray(arr, f + 1, l - 1);
    }

    static boolean validPalindrome(String s){
        StringBuilder str = new StringBuilder(s.toLowerCase());
        return validPalindrome(str, 0, str.length() - 1);
        // Time: O(n)
        // Space: O(n)
    }

    static boolean validPalindrome(StringBuilder s, int left, int right){
        if (left >= right){
            return true;
        }

        if (s.charAt(left) != s.charAt(right)){
            return false;
        }

        return validPalindrome(s, left + 1, right - 1);
    }

    static void printFibonacci(int n){
        if (n >= 1) {
            System.out.println(0);
            if (n > 1) {
                printFibonacci(n - 1, 0, 1);
            }
        }
    }

    static void printFibonacci(int n, int secondLast, int last){
        if (n == 0){
            return;
        }

        System.out.println(last);
        printFibonacci(n - 1, last, last + secondLast);
    }

    public static void main(String[] args) {
//        printNTimes(6);
//        print1toN(5);
//        System.out.println(sumOfFirstN(5));
//        System.out.println(factorial(5));
        int[] a = new int[]{1, 2, 3, 4, 5};
        reverseArray(a);
//        System.out.println(Arrays.toString(a));

//        System.out.println(validPalindrome("ABCDCBA hahhsuehuweh"));
        printFibonacci(1);











    }
}
