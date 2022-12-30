/**
 * 思路：先检查对角线，如果其中有值等于0，那么直接返回false。如果不是0，那么将其值改为0
 * 然后遍历矩阵，如果其中有值不等于0，直接返回false
 * 时间复杂度：O(n + n^2)
 * 空间复杂度：O(1)
 */
class Solution {
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        // 先检查对角线，如果其中有值等于0，那么直接返回false。如果不是0，那么将其值改为0 
        for (int i = 0; i < n; i++) {
            if (grid[i][i] == 0 || grid[i][n - 1 - i] == 0) {
                return false;
            } else {
                grid[i][i] = 0;
                grid[i][n - i - 1] = 0;
            }
        }

        // 遍历矩阵，如果其中有值不等于0，直接返回false
        for (int[] line : grid) {
            for (int e : line) {
                if (e != 0) {
                    return false;
                }
            }
        }

        return true;
    }
}