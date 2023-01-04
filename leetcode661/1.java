/**
 * Runtime complexity:O(mnC)
 * Space complexity:O(mn)
 */
class Solution {
    public int[][] imageSmoother(int[][] img) {
        // For eays of use, the length of img is stored in a variable.
        int m = img.length, n = img[0].length;
        // The ans represents the answer.
        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // The sum stores the sum f surronding grids.
                // The count stores the numbers of the cells.
                int sum = 0, count = 0;
                for (int row = i - 1; row <= i + 1; row++) {
                    for (int col = j - 1; col <= j + 1; col++) {
                        if (row >= 0 && row < m && col >= 0 && col < n) {
                            sum += img[row][col];
                            count++;
                        }
                    }
                }
                ans[i][j] = sum / count;
            }
        }

        return ans;
    }
}