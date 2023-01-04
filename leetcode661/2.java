/**
 * Runtime complexity:O(m * n);
 * Space complexity:O(m * n);
 */
class Solution {
    public int[][] imageSmoother(int[][] img) {
        // For eays of use, the length of img is stored in variables.
        int m = img.length, n = img[0].length;
        // The perfix array.
        int[][] sum = new int[m + 10][n + 10];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - sum[i - 1][j - 1] + img[i - 1][j - 1];
            }
        }

        // The ans array.
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int a = Math.max(0, i - 1), b = Math.max(0, j - 1);
                int c = Math.min(m - 1, i + 1), d = Math.min(n - 1, j + 1);
                // The numbers of cells.
                int cnt = (c - a + 1) * (d - b + 1);
                int tot = sum[c + 1][d + 1] - sum[a][d + 1] - sum[c + 1][b] + sum[a][b];
                ans[i][j] = tot / cnt;
            }
        }

        return ans;
    }
}