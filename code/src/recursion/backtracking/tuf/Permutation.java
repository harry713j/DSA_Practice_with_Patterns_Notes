package recursion.backtracking.tuf;

import java.util.Arrays;

public class Permutation {
    // imp: print all the permutation of the arr (arrangements)
    public static void permutationOne(int[] arr){
        // using an extra array or data structure
        int[] result = new int[arr.length];
        boolean[] tracker = new boolean[arr.length]; // for tracking if the element is taken or not
        permutationOne(arr, result, tracker, 0);
    }

    private static void permutationOne(int[] arr, int[] result, boolean[] tracker, int k) {
        if (k == arr.length) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!tracker[i]) { // if the element is not already taken
                result[k] = arr[i];
                tracker[i] = true;
                permutationOne(arr, result, tracker, k + 1);
                tracker[i] = false;
            }
        }

        // time: O(n * n!)
        // space: O(n)
    }

    public static void permutationTwo(int[] arr){
        // using swapping
        permutationTwo(arr, 0, arr.length - 1);
    }

    private static void permutationTwo(int[] arr, int l, int h){
        if (l == h){
            System.out.println(Arrays.toString(arr));
        } else {
            for (int i = l; i <= h; i++) {
                // swap the positions
                swap(arr, l, i);
                permutationTwo(arr, l + 1, h);
                // swap back (back-track)
                swap(arr, l, i);
            }
        }

        // time: O(n * n!)
        // space: O(n)
    }


    private static void swap(int[] arr, int s, int e){
        int t = arr[s];
        arr[s] = arr[e];
        arr[e] = t;
    }


    public static void main(String[] args) {
//        permutationOne(new int[]{1, 2, 3});
        permutationTwo(new int[]{1, 2, 3, 4});
    }
}
