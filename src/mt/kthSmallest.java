package mt;

import java.util.Arrays;

public class kthSmallest {

    public static void main(String[] args) {

        kthSmallest aa = new kthSmallest();
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        System.err.println(aa.smallest(matrix, 8));

        int[][] matrix2 = {{-5}};
        System.err.println(aa.smallest(matrix2, 1));
    }


    public int smallest(int[][] matrix, int k) {
        if (matrix.length == 1) {
            return matrix[0][k-1];
        }

        int[] help = null;
        for(int i=0; i<matrix.length; i++) {
            help = merge(help, matrix[i]);
        }

        System.err.println(Arrays.toString(help));

        return help[k-1];
    }

    public int[] merge(int[] l1, int[] l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        int[] help = new int[l1.length+l2.length];
        int p1 = 0;
        int p2 = 0;
        int h = 0;

        while (p1 < l1.length && p2 < l2.length) {
            help[h++] = l1[p1] <= l2[p2] ? l1[p1++] : l2[p2++];
        }

        while (p1 < l1.length) {
            help[h++] = l1[p1++];
        }

        while (p2 < l2.length) {
            help[h++] = l2[p2++];
        }

        return help;
    }

}
