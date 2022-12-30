/**
 * Use a variable to store xor values from 0 to n first.
 * Use this xor values to xor numbers in the nums.
 * The last remaining number must be the missing number.
 * Write the code together, which is the following code.
 * Time complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int missingNumber(int[] nums) {
        // For easy of use, the length of nums is stores in a variable.
        int len = nums.length;
        // The missing number is nums by default.
        int ans = len;
        for (int i = 0; i < len; i++) {
            ans = ans ^ i ^ nums[i];
        }

        return ans;
    }
}