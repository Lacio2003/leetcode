/**
 * website:https://leetcode.cn/problems/rotate-matrix-lcci/solutions/189835/xuan-zhuan-ju-zhen-by-leetcode-solution/
 * Time complexity:O(n^2)
 * Space complexity:O(1)
 */
class Solution {
    public void rotate(int[][] matrix) {
        // For easy of use, the length of matrix is stored in a variable.
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }
}