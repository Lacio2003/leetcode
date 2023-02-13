/*
    根据题意可以得到当前格子=min{当前行的最大值，当前列的最大值}

    时间复杂度:O(m * n)
    空间复杂度:O(m + n)
*/
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        // 保存每一行和每一列的最大值
        int m = grid.length, n = grid[0].length;
        int[] maxline = new int[m], maxCol = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 行的最大值
                maxline[i] = Math.max(maxline[i], grid[i][j]);
                // 列的最大值
                maxCol[j] = Math.max(maxCol[j], grid[i][j]);
            }
        }

        // 遍历矩阵求和
        int sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.min(maxline[i], maxCol[j]) - grid[i][j];
            }
        }

        return sum;
    }
}