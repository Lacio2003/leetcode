/**
 * 思路：在1的基础上进行了优化。遍历数组可以直接使用一个变量记录数字的正负。
 * 如果其中有0，直接返回0。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public int arraySign(int[] nums) {
        // 答案，同时记录数组中数字的正负
        int ans = 1;
        for (int e : nums) {
            // 如果有0，直接返回0
            if (e == 0) {
                return 0;
            }
            // 如果当前数字是一个负数，那么进行更新
            if (e < 0) {
                ans = -ans;
            }
        }

        return ans;
    }
}