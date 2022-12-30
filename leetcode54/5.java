/**
 * If there are no judgement conditions in the loop, the program will traverse less or more.
 * Time complexity:O(n^2)
 * Space complexity:O(1)
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // The ans stores the numbers of the matrix.
        List<Integer> ans = new ArrayList<>();
        // For easy of use, The length of matrix is stored in variable.
        int row = matrix.length, column = matrix[0].length;
        // Iterate through the required variables.
        int top = 0, bottom = row - 1, left = 0, right = column - 1;

        while (top <= bottom && left <= right) {
            // From left to right.
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            // From top to bottom.
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if (top > bottom || left > right) break;
            // From right to the left.
            for (int i = right; i >= left; i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            // From bottom to the top.
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);

            }
            left++;
        }
        return ans;
    }
}