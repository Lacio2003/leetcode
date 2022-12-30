/**
 * Time complexity:O(logn)
 * Space complexity:O(1)
 */
class Solution {
    public boolean isUgly(int n) {
        // If the current number is a negative number, return false directly.
        if (n <= 0) {
            return false;
        }

        // Divisor2, 3, 5 respectively.
        while (n % 2 == 0) {
            n /= 2;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        while (n % 5 == 0) {
            n /= 5;
        }

        // If the n divide it, the n is equal to 1, return true.Otherwise return false.
        return n == 1;
    }
}