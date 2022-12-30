/**
 * 思路：使用动态规划求解。求n就需要求n - 1，求n - 1，需要求n - 2。所以，可以使用一
 * 数组存储，自底向上计算。这样可以降低重复计算的时间复杂度。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {
    public int tribonacci(int n) {
        // 如果n < 2,直接返回。否则，数组的定义就会报错
        if (n < 2) {
            return n;
        }
        // 存储数列的数组
        int[] cache = new int[n + 1];
        // 初始化
        cache[1] = 1;
        cache[2] = 1;

        // 计算数列
        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
        }

        return cache[n];
    }
}