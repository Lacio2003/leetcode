/**
 * 思路：使用循环遍历主对角线和副对角线。
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */

class Solution {
    public int diagonalSum(int[][] mat) {
        // 记录元素的和
        int ans = 0, n = mat.length;
        // 遍历主对角线和副对角线。
        for (int i = 0; i < n; i++) {
            // 中间位置只加一次。
            ans += mat[i][i] + (i != n - i - 1 ? mat[i][n - i - 1] : 0);
        }

        return ans;
    }
}