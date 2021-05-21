package mt;

import java.util.Arrays;

//大根堆
public class HeapSort {

    public static void main(String[] args) {
        int[] aa = new int[]{3,2,14,8,9,3,5,1,8,6,0,2,11,9};

        HeapSort s = new HeapSort();
        s.heapSort(aa);
        System.err.println(Arrays.toString(aa));
    }

    public void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        // O(N*logN)
        for(int i=0; i<arr.length; i++) {
            heapInsert(arr, i);
        }
//        for(int i=arr.length-1; i>=0; i--) {
//            heapify(arr, i, arr.length);
//        }

        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        // O(N*logN)
        while(heapSize > 0) {  //O(N)
            heapify(arr, 0, heapSize);  // O(logN)
            swap(arr, 0, --heapSize);
        }


    }

    // 从index位置，往下看，不断的下沉
    // 停：较大的孩子都不再比index位置的数大；已经没子节点了
    public void heapify(int[] arr, int index, int heapSize) {
        int left = 2*index+1;
        while (left < heapSize) {
            int largest = ((left+1) < heapSize && (arr[left+1] > arr[left])) ? left+1 : left;
            if (arr[index] >= arr[largest]) {
                return;
            }

            swap(arr, index, largest);
            index = largest;
            left = 2*index+1;
        }
    }

    public void heapify2(int[] arr, int index, int heapSize) {
        int left = 2*index + 1;
        while (left < heapSize) {
            int largest = (left+1 < heapSize) && arr[left+1] > arr[left] ? left+1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }

            swap(arr, largest, index);
            index = largest;
            left = 2*index+1;
        }
    }

    //新加进来的数，现在停在了index位置，请依次往上移动，
    //移动到0为止，或者干不掉自己的父亲了，停！
    public void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index-1)/2]) {
            swap(arr, index, (index-1)/2);
            index = (index-1)/2;
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
