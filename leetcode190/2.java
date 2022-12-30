/**
 * Time complexity:O(1)
 * Space complexity:O(1)
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        // The res stores the final result.
        int res = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            // Get the current bit.
            res |= (n & 1) << (31 - i);
            n >>>= 1;
        }

        return res;
    }
}