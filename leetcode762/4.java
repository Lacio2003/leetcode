/**
 * website:https://leetcode.cn/problems/prime-number-of-set-bits-in-binary-representation/solutions/1389365/er-jin-zhi-biao-shi-zhong-zhi-shu-ge-ji-jy35g/
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int countPrimeSetBits(int left, int right) {
        // The count stores the final answer.
        int count = 0;
        for (int i = left; i <= right; i++) {
            // Get the prime of the current number.
            int cur = 1 << Integer.bitCount(i);
            if ((cur & 665772) != 0) {
                count++;
            }
        }

        return count;
    }
}