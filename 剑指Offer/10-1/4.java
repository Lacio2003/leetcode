/**
 * 使用递归来实现动态规划。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class Solution {
    // 需要除以的变量
    int m = 1000000007;
    // 存储数列的数组
    int[] cahe = new int[101];

    public int fib(int n) {
        if (n <= 1) {
            return n;
        } else if (cahe[n] != 0) {
            // 如果可以在数组当中找得到，直接返回
            return cahe[n];
        }

        // 如果数组当中没有存储，那么进行计算。
        cahe[n] = fib(n - 1) + fib(n - 2);
        cahe[n] %= m;

        return cahe[n];
    }
}