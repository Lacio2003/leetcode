/**
 * Time complexity:O(n^2)
 * Space complexity:O(1)
 */
class Solution {
    public int[][] generateMatrix(int n) {
        // A matrix that stores answers.
        int[][] matrix = new int[n][n];
        // A variable that fills with numbers.

        // Use an array to determine the direction of movement.
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int x = 0, y = 0, d = 0, i = 0, count = 1; i < n * n; i++) {
            matrix[x][y] = count++;
            // The coordinates of the next position.
            int nextX = x + dir[d][0], nextY = y + dir[d][1];
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || matrix[nextX][nextY] != 0) {
                // Change the direction of traversal.
                d = (d + 1) % 4;
                nextX = x + dir[d][0];
                nextY = y + dir[d][1];
            }

            x = nextX;
            y = nextY;
        }

        return matrix;
    }
}