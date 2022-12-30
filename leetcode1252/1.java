/**
 * 思路：直接按照要求暴力破解即可
 * 时间复杂度：遍历indices需要O(mxn)的时间，行加一和列加一需要qx(m+n)的时间。所以时间复杂度为：O(qx(m+n)+mxn)
 * 空间复杂度：O(mxn)
 */

class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        // 构造一个mxn的矩阵
        int[][] matrix = new int[m][n];

        // 遍历矩阵，按要求进行行加一和列加一
        for (int[] indice : indices) {
            // 进行列加一
            for (int i = 0; i < m; i++) {
                matrix[i][indice[1]]++;
            }

            // 进行行加一
            for (int i = 0; i < n; i++) {
                matrix[indice[0]][i]++;
            }
        }

        // 遍历矩阵找出奇数
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((matrix[i][j] & 1) == 1) {
                    ans++;
                }
            }
        }

        return ans;
    }
}