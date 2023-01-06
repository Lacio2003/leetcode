/**
 * Runtime complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    // The hash table stored the primes of 1 to 32.
    static boolean[] hash = new boolean[40];
    static {
        int[] nums = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31};
        for (int num : nums) {
            hash[num] = true;
        }
    }
    public int countPrimeSetBits(int left, int right) {
        // The count stored the number of numbers.
        int count = 0;
        for (int i = left; i <= right; i++) {
            // Get the number of one-bits of the current numbers.
            int bits = bitCount(i);
            if (hash[bits]) {
                count++;
            }
        }

        return count;
    }

    /**
     * Get the number of one-bits of the current number.
     */
    private int bitCount(int number) {
        number = (number & 0x55555555) + ((number >>> 1) & 0x55555555);
        number = (number & 0x33333333) + ((number >>> 2) & 0x33333333);
        number = (number & 0x0f0f0f0f) + ((number >>> 4) & 0x0f0f0f0f);
        number = (number & 0x00ff00ff) + ((number >>> 8) & 0x00ff00ff);
        number = (number & 0x0000ffff) + ((number >>> 16) & 0x0000ffff);

        return number;
    }
}