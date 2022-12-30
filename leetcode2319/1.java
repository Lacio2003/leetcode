/**
 * 思路：主对角线的i == j，副对角线i + j = n - 1。其他的不属于对角线。
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 检查对角线上的元素是否符合要求
                if (i == j || (i + j == n - 1)) {
                    if (grid[i][j] == 0) return false;
                } else {
                    // 检查副对角线上的元素是否符合要求
                    if (grid[i][j] != 0) return false;
                }
            }
        }

        return true;
    }
}