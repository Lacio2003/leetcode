/**
 * 思路：f(n + 1) = f(n) + f(n - 1)。这是斐波那契数列的另一个递推公式。可以通过求
 * f(n+1)。来求出f(n)。返回f(n)
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public int fib(int n) {
        // num1代表第一个数字，num2代表第二个数字，sum代表第三个数字
        int num1 = 0, num2 = 1, sum = 0;

        // 根据斐波那契数列的递推公式进行递推
        for (int i = 1; i <= n; i++) {
            // 根据题目的要求，进行取余
            sum = (num1 + num2) % 1000000007;
            // 更新第一个数字和第二个数字
            num1 = num2;
            num2 = sum;
        }
        
        return num1;
    }
}