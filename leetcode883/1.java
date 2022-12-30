/**
 * 思路：由题意可得，
 * xy的面积为矩阵当中的非零数值的个数
 * xz的面积为每一行的最大值的和
 * yz的面积为每一列的最大值的和
 * 时间复杂度:O(n^2)
 * 空间复杂度:O(1)
 */
class Solution {
    public int projectionArea(int[][] grid) {
        // 为了方便使用，将矩阵的长度存储到变量当中
        int n = grid.length;

        int xyArea = 0, xzArea = 0, yzArea = 0;
        for (int i = 0; i < n; i++) {
            int yzHeight = 0, xzHeight = 0;
            for (int j = 0; j < n; j++) {
                // 计算从顶部看的面积
                xyArea += grid[i][j] > 0 ? 1 : 0;
                // 找出每一列的最大值
                yzHeight = Math.max(yzHeight, grid[j][i]);
                // 找出每一行的最大值
                xzHeight = Math.max(xzHeight, grid[i][j]);
            }
            // 更新从侧面看立方体
            yzArea += yzHeight;
            // 更新从前面看立方体
            xzArea += xzHeight;
        }

        return xyArea + yzArea + xzArea;
    }
}