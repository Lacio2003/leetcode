/**
 * website:https://leetcode.cn/problems/binary-number-with-alternating-bits/solutions/1374269/gong-si-shui-by-ac_oier-zuw7/
 * Runtime complexity:O(1)
 * Space complexity:O(1)
 */
class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n ^ n >> 1;
        return (x & (x + 1)) == 0;
    }
}