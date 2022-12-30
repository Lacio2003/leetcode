/**
 * 思路：遍历数组，判断其中的负数的个数。如果有0，直接返回0。如果负数的个数为偶数则返回1，
 * 否则返回-1。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public int arraySign(int[] nums) {
        // 负数的个数
        int numNegative = 0;
        for (int e : nums) {
            // 如果有0直接返回0
            if (e == 0) {
                return 0;
            }
            // 统计负数的个数
            if (e < 0) {
                numNegative++;
            }
        }

        // 根据负数的个数，可以判断结果的正负。
        return (numNegative & 1) == 0 ? 1 : -1;
    }
}