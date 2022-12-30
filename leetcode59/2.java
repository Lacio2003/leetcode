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

        // Traverse the required condinates.
        int x1 = 0, y1 = 0, x2 = n - 1, y2 = n - 1;

        while (x1 <= x2 && y1 <= y2) {
            // Only one line remains.
            if (x1 == x2) {
                for (int i = y1; i <= y2; i++) {
                    matrix[x1][i] = count++;
                }
                break;
            }

            // Only one column remains.
            if (y1 == y2) {
                for (int i = x1; i <= x2; i++) {
                    matrix[i][y1] = count++;
                }
                break;
            }

            // From lefr to right.
            for (int i = y1; i < y2; i++) matrix[x1][i] = count++;
            // From top to bottom.
            for (int i = x1; i < x2; i++) matrix[i][y2] = count++;
            // From right to left.
            for (int i = y2; i > y1; i--) matrix[x2][i] = count++;
            // From bottom to top.
            for (int i = x2; i > x1; i--) matrix[i][y1] = count++;
            x1++;
            y1++;
            x2--;
            y2--;
        }

        return matrix;
    }
}