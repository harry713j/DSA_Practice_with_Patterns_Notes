package array;

import java.util.*;

public class Main {

    static int secondLargestElement(int[] arr){
        // Brute - force: first calculate the largest and then second largest;

        if (arr.length < 2){
            return -1;
        }

        int largest = arr[0];
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] < largest) {
                secondLargest = arr[i];
            }
        }

        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }

    static int secondSmallestElements(int[] arr){
        if (arr.length < 2){
            return -1;
        }

       int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;

        for (int j : arr) {
            if (j < smallest) {
                secondSmallest = smallest;
                smallest = j;
            } else if (j < secondSmallest && j != smallest){
                secondSmallest = j;
            }
        }

        return secondSmallest == Integer.MAX_VALUE ? -1 : secondSmallest;
    }

    static  List<Integer> unionOfTwoSortedArray(int[] A, int[] B){
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;

        while (i < A.length && j < B.length){
            if (A[i] <= B[j]){
                if (ans.size() == 0 || ans.get(ans.size() - 1) != A[i]){
                    ans.add(A[i]);
                }
                i++;
            } else {
                if (ans.size() == 0 || ans.get(ans.size() - 1) != B[j]) {
                    ans.add(B[j]);
                }
                j++;
            }
        }

        while (i < A.length){
            if (ans.get(ans.size() - 1) != A[i]){
                ans.add(A[i]);
            }
            i++;
        }

        while (j < B.length){
            if (ans.get(ans.size() - 1) != B[j]){
                ans.add(B[j]);
            }
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {8, 8, 7, 5, 6, 4, 9};
//
//        System.out.println(secondLargestElement(arr));
//        System.out.println(secondSmallestElements(arr));

        int[] A = {2, 4, 7, 8, 10, 18};
        int[] B = {2, 7, 8, 13, 14};
        System.out.println(unionOfTwoSortedArray(A, B));

    }
}

