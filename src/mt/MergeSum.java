package mt;

public class MergeSum {

    public int mergeLessSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        return process(arr, 0, arr.length - 1);
    }

    public int process(int[] arr, int L, int R) {
        if (L == R) {
            return 0;
        }

        int M = (L+R)/2;
        return process(arr, L, M) +
                process(arr, M+1, R) +
                merge(arr, L, M, R);
    }

    public int merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M+1;
        int ans = 0;

        while (p1<=M && p2 <= R) {
            ans += arr[p1] < arr[p2] ? arr[p1]*(R-p2+1) : 0;
            help[i++] = arr[p1] < arr[p2]? arr[p1++] : arr[p2++];
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

        return ans;
    }


    public static void main(String[] args) {
        int[] aa = new int[]{6,3,2,1,6,7};
        //0, 0, 0, 0, 6, 18    == 24  计算每位数上，左边比它小的和

        MergeSum s = new MergeSum();

        System.err.println(s.mergeLessSum(aa));
    }
}
