package demo;

import mt.HeapSort;

import java.util.Arrays;

public class DMergeSort {
    public static void main(String[] args) {
        int[] aa = new int[]{3,2,14,8,9,3,5,1,8,6,0,2,11,9};
        System.err.println(Arrays.toString(aa));
        mergeSort(aa);
        System.err.println(Arrays.toString(aa));
    }

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process(arr, 0, arr.length-1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }

        int mid = (L+R)/2;
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = M+1;
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for(int k=0; k<help.length; k++) {
            arr[L+k] = help[k];
        }
    }


}
