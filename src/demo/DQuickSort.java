package demo;

import java.util.Arrays;
import java.util.Random;

public class DQuickSort {

    public static void main(String[] args) {
        int[] aa = new int[]{3,2,14,8,9,3,5,1,8,6,0,2,11,9};
        System.out.println(Arrays.toString(aa));
        quickSort(aa);
        System.out.println(Arrays.toString(aa));
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process(arr, 0, arr.length-1);
    }

    public static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }

        swap(arr, (L + (int) (Math.random() * (R - L + 1))), R);
        int[] ranges = subSort(arr, L, R);
        process(arr, L, ranges[0]-1);
        process(arr, ranges[1]+1, R);
    }

    public static int[] subSort(int[] arr, int L, int R) {
        int less = L-1;
        int more = R;
        int cur = L;
        while (cur < more) {
            if (arr[cur] < arr[R]) {
                swap(arr, ++less, cur++);
            } else if (arr[cur] > arr[R]) {
                swap(arr, --more, cur);
            } else {
                cur++;
            }
        }

        swap(arr, more, R);

        return new int[]{less+1, more};
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
