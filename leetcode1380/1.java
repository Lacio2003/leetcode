/**
 * 思路：暴力破解。寻找每一行的最小值，然后判断这个值是不是当前列中的最大值。
 * 时间复杂度：O(n^2)
 * 空间复杂度：不算返回答案的集合，空间复杂度为O(1)
 */
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        // 存储最后的答案
        List<Integer> ans = new ArrayList<>();

        // 为了方便使用，将矩阵的长度存储到变量当中。
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            // 寻找当前行当中的最小值
            //col代表遍历的列的下标，min代表最小值的列 
            int col = 1, min = 0;
            while (col < n) {
                min = matrix[i][col] < matrix[i][min] ? col : min;
                col++;
            }

            // 寻找最小值所在列的最大值
            int row = 1, max = 0;
            while (row < m) {
                max = matrix[row][min] > matrix[max][min] ? row : max;
                row++;
            }

            // 进行对比
            if (matrix[i][min] == matrix[max][min]) {
                ans.add(matrix[i][min]);
            }
        }

        return ans;
    }
}