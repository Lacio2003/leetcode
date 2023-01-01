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

        for (int i = 0, j = 0; j < n; j++) {
            while (i < j && nums[j] - nums[i] > 1) {
                // Get a subsequence.
                i++;
            }

            if (nums[j] - nums[i] == 1) {
                // The current subsequency meets the requirements.
                ans = Math.max(abs, j - i + 1);
            }
        }
        return ans;
    }
}