/**
 * Runtimc complexity:O(mn)
 * Space complexity:O(1)
 */
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        // For easy of use, the length of mat is stored in a variable.
        int m = mat.length, n = mat[0].length;
        // According to the requirements of the topic, if the number of elements of the two matrices is different, the original matrix is returned directly.
        if (r * c != m * n) {
            return mat;
        }

        // The answer matrix.
        int[][] ans = new int[r][c];
        // Transfer the data from the origin matrix to the new matrix.
        for (int i = 0; i < m * n; i++) {
            ans[i / c][i % c] = mat[i / n][i % n];
        }

        return ans;
    }
}