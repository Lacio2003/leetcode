/**
 * 思路：依然使用动态规划的思想。但是使用静态代码块进行初始化。
 * 时间复杂度：O(C)
 * 空间复杂度：O(C)
 */
class Solution {
    // 存储数列的数组
    static int[] cache = new int[38];

    static{
        // 对数组进行填充
        cache[1] = 1;
        cache[2] = 1;
        for (int i = 3; i < 38; i++) {
            cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
        }
    }

    public int tribonacci(int n) {
        // 直接返回答案即可
        return cache[n];
    }
}