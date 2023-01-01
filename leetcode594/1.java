/**
 * Runtime complexity:O(nlogn)
 * Space complexity:O(1)
 */
class Solution {
    public int findLHS(int[] nums) {
        // Sort the nums.
        Arrays.sort(nums);
        // The ans stored the final answer.
        // The length of the nums.
        int ans = 0, n = nums.length;

        for (int i = 0, j = 0; j < n; i++) {
            // Get the current subsequence.
            while (j < n && nums[j] - nums[i] <= 1) {
                j++;
            }

            // The current subsequency meets the requirement.
            if (nums[j - 1] - nums[i] == 1) {
                ans = Math.max(ans, j - i);
            }
        }


        return ans;
    }
}