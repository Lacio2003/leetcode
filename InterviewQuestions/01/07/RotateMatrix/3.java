/**
 * website:https://leetcode.cn/problems/rotate-matrix-lcci/solutions/189835/xuan-zhuan-ju-zhen-by-leetcode-solution/
 * Time complexity:O(n^2)
 * Space complexity:O(1)
 */
class Solution {
    public void rotate(int[][] matrix) {
        // For easy of use, the length of matrix is stored in a variable.
        int n = matrix.length;
        // Horizontal reversal.
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        // The diagonal line is reversed.
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}