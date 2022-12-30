/**
 * Use a matrix to record the position is 0.Traversal the matrix,change the row and column where 0 is located.
 * Time complexity:O(n^2)
 * Space complexity:O(n^2)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        // For easy for use, The length of matrix is stored in varaible.
        int m = matrix.length, n = matrix[0].length;
        // The judge matrix is the state of the array.
        boolean[][] judge = findZero(matrix, m, n);

        // Traversal the matrix, find the zero and change. 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (judge[i][j]) {
                    changeZero(matrix, i, j);
                }
            }
        }
    }

    /**
     * Get the matrix that the state of the matrix.
     * @return A matrix that the state of the matrix.
     */
    private boolean[][] findZero(int[][] matrix, int m, int n) {
        boolean[][] judge = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                judge[i][j] = matrix[i][j] == 0;
            }
        }

        return judge;
    }

    /**
     * Change the row and column where 0 is located.
     */
    private void changeZero(int[][] matrix, int m, int n) {
        // Change the row where 0 is located.
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[m][i] = 0;
        }

        // change the column where 0 is located.
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][n] = 0;
        }
    }
}