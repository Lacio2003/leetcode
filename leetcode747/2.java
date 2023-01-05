/**
 * Find the largest integer and second largest integer.Then compare two numbers.
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int dominantIndex(int[] nums) {
        // For easy of use, the length of nums is stored in a variable.
        int n = nums.length;
        // The length of nums is 1, return directly.
        if (n == 1) {
            return 0;
        }

        // The firMax stores the largest integer in the nums.
        // The secMax stores the second largest integer in the nums.
        int firMax = 0, secMax = -1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[firMax]) {
                secMax = firMax;
                firMax = i;
            } else if (secMax == -1 || nums[i] > nums[secMax]) {
                secMax = i;
            }

        }

        return nums[firMax] >= 2 * nums[secMax] ? firMax : -1;
    }
}