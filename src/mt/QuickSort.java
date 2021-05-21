package mt;

import java.util.Arrays;

public class QuickSort {

    public void sort(int[] arr) {
        if (arr == null || arr.length< 2) {
            return;
        }

        process(arr, 0, arr.length-1);
    }

    public void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }

        swap(arr, L + (int)(Math.random()*(R-L+1)), R);
        int[] area = subsort(arr, L, R);
        process(arr, L, area[0] - 1);
        process(arr, area[1]+1, R);
    }

    public int[] subsort(int[] arr, int L, int R) {
        int less = L-1;
        int more = R;
        int index = L;
        while(index < more) {
            if (arr[index] < arr[R]) {
                swap(arr, ++less, index++);
            } else if (arr[index] > arr[R]) {
                swap(arr, index, --more);
            } else {
                index++;
            }
        }
        swap(arr, more, R);

        return new int[]{less+1, more};
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] aa = new int[]{3,2,14,8,9,3,5,1,8,6,0,2,11,9};

        QuickSort s = new QuickSort();
        s.sort(aa);
        System.err.println(Arrays.toString(aa));
    }

}
