/**
 * 思路：动态规划递归实现。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public int fib(int n) {
        // n == 0的时候需要直接返回，否则数组的定义会出错
        if (n == 0) {
            return 0;
        }
        // 存储数列的数组
        int[] dp = new int[n + 1];
        // 0和1的位置需要初始化
        dp[1] = 1;
        // 递归求解数列
        recursive(dp, 2, n);

        return dp[n];
    }

    /**
     * 递归求解斐波那契数列
     * @param dp 存放数列的数组
     * @param i 当前数字
     * @param n 要求解的第几个数字
     */
    private void recursive(int[] dp, int i, int n) {
        // 递归结束条件。
        if (i > n) {
            return;
        }

        // 进行求解
        dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        recursive(dp, i + 1, n);
    }
}