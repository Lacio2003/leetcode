/**
 * Runtime complexity:O(m * n)
 * Space complexity:O(1)
 */
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (matrix[i][j] != matrix[i + 1][j + 1]) {
                    // Each element can be compared to his lower-right element.
                    return false;
                }
            }
        }

        return true;
    }
}