/**
 * Runtime complexity:O(32)
 * Space complexity:O(1)
 */
class Solution {
    public boolean hasAlternatingBits(int n) {
        // The previous binary bit.
        int pre = n & 1;
        while (n != 0) {
            n >>= 1;
            // The current binary bit.
            int cur = n & 1;
            if (cur == pre) {
                // The bits is not alternat.
                return false;
            }
            pre = cur;
        }

        return true;
    }
}