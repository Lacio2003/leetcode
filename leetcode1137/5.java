/**
 * 思路：动态规划思想，递归实现。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    // 存放数列的数组
    int[] cache = new int[38];
    public int tribonacci(int n) {
        if (n < 3) {
            // 递归结束条件
            return n == 2 ? 1 : n;
        } else if (cache[n] != 0) {
            // 如果计算过当前数列，直接取用即可
            return cache[n];
        }

        // 没要计算过当前数列，进行计算
        cache[n] = tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
        return cache[n];
    }
}