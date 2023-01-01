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
        // The newRow is row index of the ans.
        // The newCol is column index of the ans.
        int newRow = 0, newCol = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Line break.
                if (newCol == c) {
                    newCol = 0;
                    newRow++;
                }

                ans[newRow][newCol++] = mat[i][j];
            }
        }

        return ans;
    }
}