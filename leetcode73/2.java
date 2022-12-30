/**
 * Scan the matrix twice, and the first pass records the row and column where 0 is located.The second pass, set the row and column where 0 is located to 0.
 * Time complexity:O(m * n)
 * Space complexity:O(m + n)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        // For easy for use, the length matrix is stored in variable. 
        int m = matrix.length, n = matrix[0].length;
        // The rowZero stores the rows with 0.
        Set<Integer> rowZero = new HashSet<>(); 
        // The colZero stores the columns with 0.
        Set<Integer> colZero = new HashSet<>();

        // Get the position of 0 in the matrix.
        getState(rowZero, colZero, matrix, m, n);

        // Set the row and column where 0 is located to 0.
        for (int row : rowZero) {
            for (int col : colZero) {
                changeZero(matrix, row, col, m, n); 
            }
        }
    }

    /**
     * Get the row and column where 0 is located.
     */
    private void getState(Set<Integer> rowZero, Set<Integer> colZero, int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rowZero.add(i);
                    colZero.add(j);
                }
            }
        }
    }

    /**
     * Set the row and column where 0 is located to 0.
     */
    private void changeZero(int[][] matrix, int row, int col, int m, int n) {
        // Set the row where 0 is located to 0.
        for (int i = 0; i < n; i++) {
            matrix[row][i] = 0;
        }

        // Set the column where 0 is located to 0.
        for (int i = 0; i < m; i++) {
            matrix[i][col] = 0;
        }
    }
}