/**
 * Use an array to change the direction of the traversal.
 * Time complexity:O(mn)
 * Space complexity:O(1)
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // The ans stores the numbers of the matrix.
        List<Integer> ans = new ArrayList<>();
        // For easy of use, the length of matrix is stored in variable. 
        int m = matrix.length, n = matrix[0].length;

        // The direction of the traversal.
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int x = 0, y = 0, i = 0, d = 0; i < m * n; i++)  {
            ans.add(matrix[x][y]);
            // Marks elements that have already been traversed.
            matrix[x][y] = Integer.MAX_VALUE;
            // The position of the next traversal.
            int nextX = x + dir[d][0], nextY = y + dir[d][1];

            if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n || matrix[nextX][nextY] == Integer.MAX_VALUE) {
                // Change direction.
                d = (d + 1) % 4;
                nextX = x + dir[d][0];
                nextY = y + dir[d][1];
            }

            x = nextX;
            y = nextY;
        }

        return ans;
    }
}