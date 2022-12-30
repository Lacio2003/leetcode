/**
 * 思路：暴力破解。直接遍历对角线。将其中的数字进行加总。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */

class Solution {
    public int diagonalSum(int[][] mat) {
        // 记录对角线的和。
        int ans = 0;

        // 遍历主对角线。
        for (int i = 0; i < mat.length; i++) {
            ans += mat[i][i];
        }

        // 遍历副对角线。
        for (int i = 0, j = mat.length - 1; i < mat.length && j >= 0; i++, j--) {
            // 只有中间位置才会重合，将中间位置去掉。
            if (i != j) {
                ans += mat[i][j];
            }
        }

        return ans;
    }
}