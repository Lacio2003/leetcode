/**
 * 思路：暴力破解：直接遵照题目的意思，生成矩阵并填充。
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n^2)
 */

class Solution {
    public int[][] largestLocal(int[][] grid) {
        // 生成的数组的长度
        int length = grid.length - 2;
        // 答案数组
        int[][] ans = new int[length][length];
        // 填充数组
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // 寻找3x3矩阵当中的最大值
                ans[i][j] = max(grid, i + 1, j + 1);
            }
        }

        return ans;
    }

    /**
     * @param grid 矩阵
     * @param row 开始寻找位置的行
     * @param column 开始寻找位置的列
     * @return 3x3矩阵当中的最大值
     */
    private int max(int[][] grid, int row, int column) {
        // 存储最大值
        int max = grid[row][column];
        // 开始寻找最大值
        for (int i = row - 1; i < row + 2; i++) {
            for (int j = column - 1; j < column + 2; j++) {
                if (grid[i][j] > max) {
                    max = grid[i][j];
                }
            }
        }

        return max;
    }
}