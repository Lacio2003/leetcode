/**
 * Another way of writing divide.
 * Time complexity:O(1)
 * Space complexity:O(1)
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        n = ((n & 0xAAAAAAAA) >>> 1) | ((n & 0x55555555) << 1);
        n = ((n & 0xCCCCCCCC) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xF0F0F0F0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xFF00FF00) >>> 8) | ((n & 0x00ff00ff) << 8);
        // n = ((n & 0xFFFF0000) >>> 16) | ((n & 0x0000ffff) << 16);
        n = (n >>> 16) | (n << 16);
        return n;
    }
}