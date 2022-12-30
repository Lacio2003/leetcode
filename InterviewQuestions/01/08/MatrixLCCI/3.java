/**
 * Runtime complexity:O(n^2)
 * Space complexity:O(m + n)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        // For easy of use, the length matrix is stored in a variable.
        int n = matrix.length, m = matrix[0].length;
        // The rows stores the where 0 is located.
        // The cols stores the where 0 is located.
        boolean[] rows = new boolean[n], cols = new boolean[m];

        // Record the position of 0 in the array.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // Modify the row and column where 0 is located.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rows[i] || cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}