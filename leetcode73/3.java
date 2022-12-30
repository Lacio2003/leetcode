/**
 * Store the element is 0 in the first column and row.
 * Time complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {

    // Whether the first row and the column is 0.
    boolean rowZero = false, colZero = false; 
    public void setZeroes(int[][] matrix) {
        // For easy of use, the length of matrix is stored in variable.
        int m = matrix.length, n = matrix[0].length;
        judgeFirst(matrix, m, n);
        getState(matrix, m, n);
        changeZero(matrix, m, n);
    }

    /**
     * Determine whether the first row and column is 0.
     */
    private void judgeFirst(int[][] matrix, int m, int n) {
        // Determine whether the first column is 0.
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                colZero = true;
                break;
            }
        }

        // Determine whether the first row is 0.
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                rowZero = true;
                break;
            }
        }
    }

    /**
     * Determine if there are 0 for other elements other than the first row and the
     * first column, and if so, record in the first rwo and column.
     */
    private void getState(int[][] matrix, int m, int n) {
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // Record in the first row and column
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
    }

    /**
     * Set the correpsonding position is 0.
     */
    private void changeZero(int[][] matrix, int m , int n) {
        // Set the corresponding columns is 0.
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }

        // Set the corrsponding row is 0.
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowZero) {
            // Set the first row is 0.
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }

        if (colZero) {
            // Set the second column is 0.
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}