/**
 * Another way to write 4.
 * Time complexity:O(m * n)
 * Space complexity:O(1)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        // The rowZero stores whether the first row is 0.
        boolean rowZero = false;
        // For easy of use, the length of matrix is stored in variable.
        int m = matrix.length, n = matrix[0].length;

        // The position of the 0 element records in the first row and column.
        for (int i = 0; i < n; i++) {
            // Determine whether the element has 0 in the first row.
            if (matrix[0][i] == 0) {
                rowZero = true;
            }
            for (int j = 1; j < m; j++) {
                if (matrix[j][i] == 0) {
                    // The position of the 0 element records in the first column and row.
                    matrix[0][i] = matrix[j][0] = 0;
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 1; j--) {
                if (matrix[0][i] == 0 || matrix[j][0] == 0) {
                    // Set the corresponding column and row to 0.
                    matrix[j][i] = 0;
                }
            }
            // Special treatment is required for the first row, otherwise if the first row does not have 0, it will also becomes 0.
            if (rowZero) {
                // Set the first row to 0.
                matrix[0][i] = 0;
            }
        }
    }
}