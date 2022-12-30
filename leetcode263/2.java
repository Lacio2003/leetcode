/**
 * Time complexity:O(logn)
 * Space complexity:O(1)
 */
class Solution {
    public boolean isUgly(int n) {
        // The n is negative number, return false directly.
        if (n <= 0) {
            return false;
        }

        // The divided numbers.
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }

        return n == 1;
    }
}