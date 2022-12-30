/**
 * 思路：使用两个数组分别存储每一行的最小值和每一列的最大值，
 * 然后遍历两个数组。如果最小值和最大值能够对应上，证明这个数字就是
 * 时间复杂度：O(mxn)
 * 空间复杂度：O(m+n)
 */
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        // 存储答案的集合
        List<Integer> ans = new ArrayList<>();

        // 为了方便使用，将矩阵的mxn的长度存储到变量当中。
        int m = matrix.length, n = matrix[0].length;

        // 存储每一行的最小值
        int[] minRow = new int[m];
        // 为了进行填充，实现将所有的值填充为最大
        Arrays.fill(minRow, Integer.MAX_VALUE);
        // 存储每一列的最大值
        int[] maxCol = new int[n];
        // 为了进行填充，实现将所有的值填充为最小
        Arrays.fill(maxCol, Integer.MIN_VALUE);

        // 遍历集合，填充两个数组
        // i代表当前行，j代表当前列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 更新每一行的最小值
                minRow[i] = Math.min(matrix[i][j], minRow[i]);
                // 更新最一列的最大值
                maxCol[j] = Math.max(matrix[i][j], maxCol[j]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (minRow[i] == maxCol[j]) {
                    ans.add(minRow[i]);
                }
            }
        }

        return ans;

    }
}