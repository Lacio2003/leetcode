/**
 * Runtime complexity:O(m*n)
 * Space complexity:O(1)
 */
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        // For eays of use, the length of matrix is stored in a variable.
        int m = matrix.length, n = matrix[0].length;
        // Check the horizontal diagonal.
        for (int i = 0, j = 0; j < n; j++) {
            if (!checkDiagonal(matrix, i, j)) {
                return false;
            }
        }

        // Check the vertical diagonal.
        for (int i = 1, j = 0; i < m; i++) {
            if (!checkDiagonal(matrix, i, j)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Check the diagonal.
     */
    private boolean checkDiagonal(int[][] matrix, int row, int col) {
        int m = matrix.length, n = matrix[0].length;
        int curNum = matrix[row][col];
        while (row < m && col < n) {
            if (matrix[row][col] != curNum) {
                // The elements of diagonal is not same.
                return false;
            }
            row++;
            col++;
        }

        return true;
    }
}