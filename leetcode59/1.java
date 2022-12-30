/**
 * Time complexity:O(n^2)
 * Space complexity:O(1)
 */
class Solution {
    public int[][] generateMatrix(int n) {
        // A matrix that stores answers.
        int[][] matrix = new int[n][n];
        // A variable that fills with numbers.
        int count = 1;
        // Iterate through the required variables.
        int top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (top <= bottom && left <= right) {
            // From left to right.
            for (int i = left; i <= right; i++) {
                matrix[top][i] = count++;
            }
            top++;
            // From top to bottom.
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = count++;
            }
            right--;

            // When there is only row or column left, the traversal is cmoplete and the loop is stoped.
            if (top > bottom || left > right) break;

            // From right to left.
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = count++;
            }

            bottom--;
            // From bottom to top.
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = count++;
            }
            left++;
        }

        return matrix;
    }
}