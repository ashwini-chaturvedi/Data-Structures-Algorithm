// Very Good Question 
// Other than Basic Spiral approach it uses direction propagation pattern 
class Solution {

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[][] matrix = new int[rows * cols][2];

        matrix[0] = new int[] { rStart, cStart }; //Starting points;
        int count = 1;
        int currDir = 0;
        int steps = 0;
        while (count < rows * cols) {
            if (currDir == 0 || currDir == 2) steps++;

            for (int i = 0; i < steps; i++) {
                rStart += directions[currDir][0];
                cStart += directions[currDir][1];
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    matrix[count++] = new int[] { rStart, cStart };
                }
            }
            currDir = (currDir + 1) % 4;
        }
        return matrix;
    }
}
