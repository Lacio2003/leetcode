/**
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        // For eays of use, the length of nums is stored in a variable.
        int n = nums.length;
        // The xor represents the result of duplicated number ^ lossing number.
        int xor = 0;
        for (int i = 1; i <= n; i++) {
            xor ^= nums[i - 1];
            xor ^= i;
        }

        int lowbits = xor & (-xor);
        int num1 = 0, num2 = 0;

        for (int i = 1; i <= n; i++) {
            if ((nums[i - 1] & lowbits) == 0) {
                num1 ^= nums[i - 1];
            } else {
                num2 ^= nums[i - 1];
            }

            if ((i & lowbits) == 0) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }

        // Make a distinction between two numbers.
        for (int e : nums) {
            if (e == num1) {
                return new int[]{num1, num2};
            }
        }

        return new int[]{num2, num1};
    }
}