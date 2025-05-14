package sorting.impl;

import java.util.Arrays;

public class BasicSortingAlgorithms {
    static void swap(int[] arr, int s, int e){
        int temp = arr[s];
        arr[s] = arr[e];
        arr[e] = temp;
    }

    static void selectionSort(int[] arr){
        // select the minimum and put it in the right position
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            // swap the position i.e. bring minimum element to first
            swap(arr, i, minIndex);
        }
        // worst time: O(n^2)
        // average time: O(n^2)
        // best time: O(n^2)
    }

    static void bubbleSort(int[] arr){
        // in each iteration pushes the maximum to the last
        int n = arr.length;
        for (int i = n - 1; i >= 0 ; i--) {
            boolean isSwapped = false; // if the element is not swap for at least one time for an iteration
            // i.e. the array already sorted
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]){
                    swap(arr, j, j + 1);
                    isSwapped = true;
                }
            }

            if (!isSwapped){
                break;
            }
        }
        // worst time: O(n^2)
        // average time: O(n^2)
        // best time: O(n)
    }

    static void insertionSort(int[] arr){
        // take an element and place in its correct position
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]){
                swap(arr, j, j - 1);
                j--;
            }
        }
        // worst time: O(n^2)
        // average time: O(n^2)
        // best time: O(n)
    }

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
//        selectionSort(arr);
//        bubbleSort(arr);
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
