/**
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        // For eays of use, the length of matrix is stored in a variable.
        int m = matrix.length, n = matrix[0].length;
        // Check the horizontal diagonal.
        for (int i = 0, j = 0, count = 0; i + count < m || j + count < n; count++) {
            if ((j + count < n && !checkDiagonal(matrix, 0, j + count)) || (i + count < m && !checkDiagonal(matrix, i + count, 0))) {
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