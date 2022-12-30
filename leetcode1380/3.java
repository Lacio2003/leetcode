/**
 * 思路：根据题目可得，二维数组当中的幸运数是所有行的最小值的最大值，所有列当中的最大值的最小值。所以，先寻找所有行的最小值的最大值。并记录列数。然后检查这个是不是在那一列中的最大值。如果是，则是幸运数。否则就不是。
 * 时间复杂度：O(mxn)
 * 空间复杂度：O(1)
 */
class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        // 存放最后的答案
        List<Integer> ans = new ArrayList<>();
        // 为了方便使用，将矩阵的长度和宽度存放到变量当中
        int m = matrix.length, n = matrix[0].length;

        // maxRow代表行的最大值，k代表那个值所在的列
        int maxRow = 0, k = 0;
        for (int i = 0; i < m; i++) {
            // curMin代表当前行最小的值，c代表最小值所在的列
            int curMin = matrix[i][0], c = 0;
            for (int j = 1; j < n; j++) {
                if (curMin > matrix[i][j]) {
                    curMin = matrix[i][j];
                    c = j;
                }
            }

            // 更新行中最小值的最大值
            if (maxRow < curMin) {
                maxRow = curMin;
                k = c;
            }
        }


        // 检查行的最小值中的所有的最大值是否是指定列中的最大值，如果不是说明不存在
        // 幸运数
        for (int i = 0; i < m; i++) {
            if (maxRow < matrix[i][k]) {
                return ans;
            }
        }

        // 如果循环通过，说明存在幸运数
        ans.add(maxRow);

        return ans;
    }
}