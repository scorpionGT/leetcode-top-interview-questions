package demo;

import java.util.Arrays;

public class DHeapSort {
    public static void main(String[] args) {
        int[] aa = new int[]{3,2,14,8,9,3,5,1,8,6,0,2,11,9};
        System.out.println(Arrays.toString(aa));
        heapSort(aa);
        System.out.println(Arrays.toString(aa));
    }

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

//        for(int i=0; i<arr.length; i++) {
//            heapInsert(arr, i);
//        }

        for(int i=arr.length-1; i>=0; i--) {
            heapify(arr, i, arr.length);
        }


        int heapSize = arr.length;
        swap(arr, 0, --heapSize);

        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }

    public static void heapify(int[] arr, int index, int heapSize) {
        int left = 2*index+1;
        while(left < heapSize) {
            int largest = (left+1 < heapSize) && (arr[left+1] > arr[left]) ? left+1 : left;
            if (arr[index] >= arr[largest]) {
                return;
            }

            swap(arr, index, largest);
            index = largest;
            left = 2*index+1;
        }
    }

    public static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index-1)/2]) {
            swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
