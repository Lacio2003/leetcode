/**
 * Runtime complexity:O(n^2)
 * Space complexity:O(1)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        // For easy of use, the length of matrix is stored in variable.
        int m = matrix.length, n = matrix[0].length;
        // The corZero Determine if the first column has 0.
        boolean corZero = false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                // The first column has 0.
                corZero = true;
            }
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // Set the position corresponding to the first row and column to 0.
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Modify the matrix.
        for (int i = m - 1; i > -1; i--) {
            for (int j = n - 1; j > 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (corZero) {
                // Set the first column to 0.
                matrix[i][0] = 0;
            }
        }
    }
}