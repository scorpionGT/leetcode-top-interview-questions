package demo;

public class DkthSmallest {

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k= 8;

        System.err.println(findKthSmallest(matrix, 8));

        int[][] matrix2 = {{-5}};
        System.err.println(findKthSmallest(matrix2, 1));
    }

    public static int findKthSmallest(int[][] matrix, int k) {
        if (matrix == null) {
            return -1;
        }

        if (matrix.length == 1) {
            return matrix[0][k-1];
        }

        int[] m = matrix[0];
        for(int i=1; i<matrix.length; i++) {
            m = mergeArray(m, matrix[i]);
        }

        return m[k-1];
    }

    public static int[] mergeArray(int[] a1, int[] a2) {
        int[] help = new int[a1.length+a2.length];
        int i= 0;
        int k1 = 0;
        int k2 = 0;

        while (k1<a1.length && k2<a2.length) {
            help[i++] = a1[k1] < a2[k2] ? a1[k1++] : a2[k2++];
        }
        while (k1<a1.length) {
            help[i++] = a1[k1++];
        }
        while (k2<a2.length) {
            help[i++] = a2[k2++];
        }

        return help;
    }
}
