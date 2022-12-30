/**
 * Use a matrix to store the rotate matrix.Then The data of the roatae matrix will be stored as the orignal matrix.
 * Runtime complexity:O(n^2)
 * Space complexity:O(n^2)
 */
class Solution {
    public void rotate(int[][] matrix) {
        // For easy of use, the length of matrix is stored in a variable.
        int n = matrix.length;
        // The ans stores the rotate matrix.
        int[][] ans = new int[n][n];

        // Rotate the matrix.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = matrix[n - j - 1][i];
            }
        }

        // The data will be stored as the original matrix.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ans[i][j];
            }
        }
    }
}