/**
 * 思路：使用动态规划的思想。在1、2即基础上进一步优化。将数组变成三个变量
 * 进一步节省空间复杂度
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public int tribonacci(int n) {
        // n小于2时，直接返回n即可
        if (n < 2) {
            return n;
        }

        // 三个变量，反别代表三个数字
        int first = 0, second = 1, third = 1, ans = 1;
        // 计算序列
        for (int i = 3; i <= n; i++) {
            ans = first + second + third;
            first = second;
            second = third;
            third = ans;
        }

        return ans;
    }
}