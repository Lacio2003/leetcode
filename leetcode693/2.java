/**
 * Runtime complexity:O(32)
 * Space complexity:O(1)
 */
class Solution {
    public boolean hasAlternatingBits(int n) {
        while (n != 0) {
            // Take out two binaries at time.
            int cur = n & 3;
            if (cur == 0 || cur == 3) {
                // The two binaries is same.
                return false;
            }

            n >>= 1;
        }
        return true;
    }
}