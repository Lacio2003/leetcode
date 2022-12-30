/**
 * Time complexity:O(n^3)
 * Space complexity:O(n^2)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        // For easy of use, the length of matrix is stored in variables.
        int m = matrix.length, n = matrix[0].length;
        // The mark record the position of 0 in the array. 
        boolean[][] mark = new boolean[m][n];

        // Record the position of 0 in the array.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    mark[i][j] = true;
                }
            }
        }

        // Modify the row and column where 0 is located.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mark[i][j] == true) {
                    modifyMatrix(matrix, i, j);
                }
            }
        }
    }

    /**
     * Modify the row and column where 0 is located.
     */
    private void modifyMatrix(int[][] matrix, int row, int col) {
        int m = matrix.length, n = matrix[0].length;
        // Modify the row where 0 is located.
        for (int i = 0; i < m; i++) {
            matrix[i][col] = 0;
        }

        // Modify the column 0 is located.
        for (int j = 0; j < n; j++) {
            matrix[row][j] = 0;
        }
    }
}