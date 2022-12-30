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

        while (top <= bottom || left <= right) {
            for (int i = left; i <= right && top <= bottom; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom && left <= right; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left && bottom >= top; i--) {
                ans.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top && right >= left; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}