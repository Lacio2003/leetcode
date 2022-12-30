/**
 * Optimize on the basis of 3.
 * Time complexity:O(mn)
 * Space complexity:O(1)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        // The colZero stores whether the first column is 0.
        boolean colZero = false;
        // For easy of use, the length of matrix is stored in variable. 
        int m = matrix.length, n = matrix[0].length;

        // Elements that are 0 are recorded in the first row and column
        for (int i = 0; i < m; i++) {
            // Determine whether the first column is 0.
            if (matrix[i][0] == 0) {
                colZero = true;
            }

            // Judge each element.
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        } 

        // Traverse the matrix and set the corresponding position is 0.
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    // Set the corresponding position is 0.
                    matrix[i][j] = 0;
                }
            }
            // The first column is set to 0.
            if (colZero) {
                matrix[i][0] = 0;
            }
        }
    }
}