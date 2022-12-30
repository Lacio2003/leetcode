/**
 * 思路：f(n + 3) = f(n) + f(n + 1) + f(n + 2)。使用这个公式可以避免需要对前面的
 * 数字做特殊处理。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public int tribonacci(int n) {
        // ans代表f(n)， first代表f(n+1)，second代表f(n+2)，sum代表f(n+2)
        int ans = 0, first = 1, second = 1, sum = 0;
        
        // 计算数列
        for (int i = 1; i <= n ;i++) {
            sum = ans + first + second;

            ans = first;
            first = second;
            second = sum;
        }

        return ans;
    }
}