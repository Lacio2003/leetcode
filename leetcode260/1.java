/**
 * Brute force cracking.
 * Time compleixty:O(n^2)
 * Space complexity:O(1)
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        // The ans stores the final answer.
        int[] ans = new int[2];
        // The index of ans.
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            // Whether the current number has ever appeared.
            boolean is = false;
            for (int j = 0; j < nums.length; j++) {
                if (j != i && nums[i] == nums[j]) {
                    // The current number has ever appeared.
                    is = true;
                    break;
                }
            }
            if (!is) {
                // The current number is unique within the array.
                ans[index++] = nums[i];
            }
        }

        return ans;
    }
}