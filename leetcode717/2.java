/**
 * website:https://leetcode.cn/problems/1-bit-and-2-bit-characters/solutions/1278132/fu-xue-ming-zhu-tu-jie-suan-fa-zou-yi-bu-shvh/
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] == 0 ? 1 : 2;
        }

        return i == bits.length - 1;
    }
}