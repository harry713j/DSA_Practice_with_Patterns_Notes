package sorting.impl;

import java.util.Arrays;

public class RecursiveSortingAlgorithms {
    static void swap(int[] arr, int s, int e){
        int t = arr[s];
        arr[s] = arr[e];
        arr[e] = t;
    }

    static void bubbleSort(int[] arr, int n){
        if (n == 1){
            return;
        }

        boolean isSwapped = false;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]){
                swap(arr, i, i + 1);
                isSwapped = true;
            }
        }

        if (!isSwapped){
            return;
        }

        bubbleSort(arr, n - 1);
    }

    static void insertionSort(int[] arr, int i){
        if (i == arr.length){
            return;
        }

        int j = i;
        while (j > 0 && arr[j] < arr[j - 1]){
            swap(arr, j, j - 1);
            j--;
        }

        insertionSort(arr, i + 1);
    }

    static int[] mergeSort(int[] arr, int start, int end){
        if (end - start == 0){
            return new int[]{arr[start]};
        }

        int mid = (start + end) / 2;

        int[] left = mergeSort(arr, start, mid);
        int[] right = mergeSort(arr, mid + 1, end);

        int[] merged = merge(left, right);

        return merged;
        // time: O(n log n)
        // space: O(n)
    }

    static int[] merge(int[] left, int[] right){
        int i = 0, j = 0, k = 0;
        int n = left.length, m = right.length;
        int[] merged = new int[m + n];

        while (i < n && j < m){
            if (left[i] < right[j]){
                merged[k] = left[i];
                i++;
            } else {
                merged[k] = right[j];
                j++;
            }
            k++;
        }

        // add remaining elements
        while (i < n){
            merged[k] = left[i];
            i++; k++;
        }

        while (j < m){
            merged[k] = right[j];
            j++; k++;
        }

        return merged;
        // time: O(m + n)
        // space: O(m + n)
    }

    static void mergeSortInPlace(int[] arr, int start, int end){
        if (end - start == 0){
            return;
        }

        int mid = (start + end) / 2;
        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid + 1, end);

        mergeInPlace(arr, start, mid, end);
        // time: O(n Log n)
        // space: O(n)
    }

    static void mergeInPlace(int[] arr, int start, int mid, int end){
        int i = start, j = mid + 1, k = 0;
        int[] merged = new int[end - start + 1];

        while (i <= mid && j <= end){
            if (arr[i] < arr[j]){
                merged[k] = arr[i];
                i++;
            } else {
                merged[k] = arr[j];
                j++;
            }
            k++;
        }

        // remaining elements
        while (i <= mid){
            merged[k] = arr[i];
            i++; k++;
        }

        while (j <= end){
            merged[k] = arr[j];
            j++; k++;
        }

        // copy the elements of merged to arr;
        for (int l = 0; l < merged.length; l++) {
            arr[start + l] = merged[l];
        }
    }

    static void quickSort(int[] arr, int start, int end){
        if (start >= end){
            return;
        }

        int partitionIndex = partition(arr, start, end);
        quickSort(arr, start, partitionIndex - 1);
        quickSort(arr, partitionIndex + 1, end);
        // time: O(n Log n) for best and average for worst case like array is already sorted or reversely sorted O(n^2)
        // space: O(1)
    }

    private static int partition(int[] arr, int start, int end) {
        // we are taking the first element as pivot
        int pivot = arr[start];
        int i = start, j = end;

        while (i < j){
            // find the element that is greater than pivot from start
            while (i <= end && arr[i] <= pivot){
                i++;
            }
            // find the element that is lesser than pivot from end
            while (j >= start && arr[j] >= pivot){
                j--;
            }
            // swap them
            if (i < j){
                swap(arr, i, j);
            }
        }

        // put the pivot at its correct index
        swap(arr, start, j);
        return j;
        // time: O(n)
        // space: O(1)
    }

    public static void main(String[] args) {
        int[] arr = {13, 42, 24, 52, 20, 9};
//        bubbleSort(arr, arr.length);
//        insertionSort(arr, 1);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
//        mergeSortInPlace(arr, 0, arr.length - 1);
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
