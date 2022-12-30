/**
 * Runtime complexity:O(n^2)
 * Space complexity:O(1)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        // The rowZero record whether the first row has 0.
        // The colZero record whether the first column has 0.
        boolean rowZero = false, colZero = false;
        // For easy of use, the length of matrix is stored in variable.
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Determine if the first line has 0.
                if (i == 0 && matrix[i][j] == 0) {
                    rowZero = true;
                }
                // Determine if the first column has 0.
                if (j == 0 && matrix[i][j] == 0) {
                    colZero = true;
                }

                if (matrix[i][j] == 0) {
                    // Set the position corresponding to the first row and column to 0.
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set the corresponding position in the matrix to 0.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }

        }

        // Set the first column to the 0.
        for (int i = 0; i < m && colZero; i++) {
            matrix[i][0] = 0;
        }

        // Set the first row to the 0.
        for (int i = 0; i < n && rowZero; i++) {
            matrix[0][i] = 0;
        }
    }
}