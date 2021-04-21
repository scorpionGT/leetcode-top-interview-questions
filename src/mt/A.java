package mt;

import java.util.Arrays;

public class A {

    public void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        process(arr, 0, arr.length - 1);
        return;
    }

    public void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }

        int M = (L+R)/2;
        process(arr, L, M);
        process(arr, M+1, R);
        merge(arr, L, M, R);
    }

    public void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M+1;

        while (p1<=M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2]? arr[p1++] : arr[p2++];
        }
        while (p1<=M ) {
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for(int j=0; j<help.length; j++) {
            arr[L+j] = help[j];
        }

    }


    public static void main(String[] args) {
        int[] aa = new int[]{3,2,14,8,9,3,5,1,8,6,0,2,11,9};
        int[] bb = new int[]{3,2,14,8,9,3,5,1,8,6,0,2,11,9};

        A s = new A();
        s.mergeSort(aa);
        System.err.println(Arrays.toString(bb));
        System.err.println(Arrays.toString(aa));
    }
}
