/**
 * Brute force carcking.
 * Time complexity:O(n^2);
 * Space complexity:O(1)
 */
class Solution {
    public int singleNumber(int[] nums) {
        // The ans stores th final answer.
        int ans = nums[0];
        // For easy of use, the length of nums is stored in a variable.
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // Determine if the current number appears twice.
            boolean is = false;
            for (int j = 0; j < len; j++) {
                if (j != i && nums[i] == nums[j]) {
                    // The current number appears twice.
                    is = true;
                    break;
                }
            }
            if (!is) {
                // The current number appears once.
                ans = nums[i];
                break;
            }
        }

        return ans;
    }
}