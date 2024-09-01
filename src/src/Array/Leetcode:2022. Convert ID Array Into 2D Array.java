class Solution {

    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != len) return new int[0][0];

        int[][] matrix = new int[m][n];
        int len = original.length;
        int k = 0;
        for (int i = 0; i < m && k < len; i++) {
            for (int j = 0; j < n && k < len; j++) {
                matrix[i][j] = original[k++];
            }
        }

        return matrix;
    }
}
