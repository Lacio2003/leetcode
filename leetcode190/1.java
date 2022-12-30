/**
 * Time complexity:O(1);
 * Space complexity:O(1);
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // The res stores the final result.
        int res = 0;
        for (int i = 0; i < 32; i++) {
            // Get the final bit.
            int cur = n & 1;
            // Add the last space.
            res = (res << 1) ^ cur;
            n >>>= 1;
        }

        return res;
    }
}