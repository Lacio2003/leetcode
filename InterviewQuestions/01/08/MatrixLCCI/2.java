/**
 * Runtime complexity:O(n^3)
 * Space complexity:O(m + n)
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        // For easy of use, the length matrix is stored in a variable.
        int n = matrix.length, m = matrix[0].length;
        // The rows stores the where 0 is located.
        // The cols stores the where 0 is located.
        List<Integer> rows = new ArrayList<>(), cols = new ArrayList<>();

        // Record the position of 0 in the array.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        // Modify the row and column where 0 is located.
        for (int i = rows.size() - 1; i > -1; i--) {
            for (int j = cols.size() - 1; j > -1; j--) {
                modifyMatrix(matrix, rows.get(i), cols.get(j));
            }
        }

    }

    /**
     * Modify the row and column where 0 is located.
     */
    private void modifyMatrix(int[][] matrix, int row, int col) {
        int n = matrix.length, m = matrix[0].length;
        for (int i = 0; i < m + n; i++) {
            if (i < m) {
                matrix[row][i] = 0;
            }
            if (i < n) {
                matrix[i][col] = 0;
            }
        }
    } 
}