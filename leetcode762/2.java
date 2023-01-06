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
            int bits = 0, x = i;
            // Get the number of one-bits of the current numbers.
            while (x != 0) {
                x = x & (x - 1);
                bits++;
            }

            if (hash[bits]) {
                count++;
            }
        }

        return count;
    }
}