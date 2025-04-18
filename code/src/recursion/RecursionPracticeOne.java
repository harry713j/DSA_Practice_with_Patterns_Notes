package recursion;

import java.util.Arrays;

public class RecursionPracticeOne {

    static void sumTriangle(int[] arr){
        if (arr.length < 1){
            return;
        }
        int[] temp = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            temp[i] = arr[i] + arr[i + 1];
        }

        sumTriangle(temp);
        System.out.println(Arrays.toString(arr));
    }

    static int maxOfArray(int[] arr, int length){
        if (length == 1){
            return arr[0];
        }

        return Math.max(arr[length - 1], maxOfArray(arr, length - 1));
    }

    static int minOfArray(int[] arr, int len){
        if (len == 1){
            return arr[0];
        }

        return Math.min(arr[len - 1], minOfArray(arr, len - 1));
    }

    static char firstUppercase(String str){
        if (str.isEmpty()){
            return 0;
        }
        if (Character.isUpperCase(str.charAt(0))){
            return str.charAt(0);
        }

        return firstUppercase(str.substring(1));
    }

    static int recursiveBinarySearch(int[] arr, int target, int start, int end){
        if (start <= end){
            int mid = (start + end) / 2;
            if (arr[mid] == target){
                return mid;
            } else if (arr[mid] > target) {
                return recursiveBinarySearch(arr, target, start, mid - 1);
            } else {
                return recursiveBinarySearch(arr, target, mid + 1, end);
            }
        }
        return -1;
    }

    static void reverseString(char[] s){
        if (s.length < 2){
            return;
        }
        int start = 0, end = s.length - 1;
        reverseStringHelper(s, start, end);
    }

    static void reverseStringHelper(char[] s, int i, int j){
        if (i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;

            reverseStringHelper(s, i + 1, j - 1);
        }
    }

    static int fibonacciNumber(int n){
        int[] memo = new int[n + 1];

        Arrays.fill(memo, -1);
        return fibonacciNumberHelper(n, memo);
    }

     static int fibonacciNumberHelper(int n, int[] memo) {
        if (n < 2){
            memo[n] = n;
            return n;
        }

        if (memo[n - 2] == -1){
            memo[n - 2] = fibonacciNumberHelper(n - 2, memo);
        }

        if (memo[n - 1] == -1){
            memo[n - 1] = fibonacciNumberHelper(n - 1, memo);
        }

        memo[n] = memo[n - 2] + memo[n - 1];
        return memo[n];
    }

    static int sumOfDigit(int num){
        if (num == 0){
            return 0;
        }
        return num % 10 + sumOfDigit(num / 10);
    }

    static boolean isPowerOfTwo(int n){
//        if (n <= 0){
//            return false;
//        }
//
//        if (n == 1){
//            return true;
//        }
//
//        if (n % 2 != 0){
//            return false;
//        }
//
//        return isPowerOfTwo(n / 2);
        if (n < 1)
            return false;

        return (n & (n - 1)) == 0;
    }

    static boolean isPowerOfThree(int n){
        if (n < 1){
            return false;
        }
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    static boolean isPowerOfFour(int n){
        return n>0 && (n & (n-1))==0 && (n-1)%3==0;
    }

    static int calculatePower(int n, int a, int x){
        if (n == 1){
            return x;
        }
        return calculatePower(n / a, a, x + 1);
    }

    public static void main(String[] args) {
//        sumTriangle(new int[]{1, 2, 3, 4, 5});
        int[] array = {1, 2, 5, 9, 13, 17};
//        System.out.println("Min of array: " + minOfArray(array, array.length) +
//                " & Max of array: " + maxOfArray(array, array.length));

//        System.out.println(firstUppercase(""));
        char[] s = "hellothere".toCharArray();
//        System.out.println(recursiveBinarySearch(array, 10, 0, array.length - 1));
//        reverseString(s);
//        System.out.println(Arrays.toString(s));
//        System.out.println(fibonacciNumber(11));
//        System.out.println(sumOfDigit(0));
//        System.out.println(isPowerOfTwo(5));
//        System.out.println((isPowerOfTwo(5776)));
//        System.out.println(isPowerOfThree(243));
        System.out.println(calculatePower(8, 3, 0));
    }

}
