/**
 * Time complexity:O(n^2)
 * Space complexity:O(n^2)
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // The ans stores the numbers in the matrix.
        List<Integer> ans = new ArrayList<>();
        // For easy of use, The row and columns is stored in variable.
        int row = matrix.length, column = matrix[0].length;
        // Iterable through the required variables.
        int top = 0, bottom = row - 1, left = 0, right = column - 1;
        // A matrix used to record status.
        boolean[][] is = new boolean[row][column];

        while (top <= bottom && left <= right) {
            // Traverse to the right.
            for (int i = left; i <= right && !is[top][i]; i++) {
                ans.add(matrix[top][i]);
                is[top][i] = true;
            }
            top++;
            // Traverse to the bottom.
            for (int i = top; i <= bottom && !is[i][right]; i++) {
                ans.add(matrix[i][right]);
                is[i][right] = true;
            }
            right--;
            // Traverse to the left.
            for (int i = right; i >= left && !is[bottom][i]; i--) {
                ans.add(matrix[bottom][i]);
                is[bottom][i] = true;
            }
            bottom--;
            // Traverse to the top.
            for (int i = bottom; i >= top && !is[i][left]; i--) {
                ans.add(matrix[i][left]);
                is[i][left] = true;
            }
            left++;
        }

        return ans;
    }
}