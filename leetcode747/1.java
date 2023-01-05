/**
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int dominantIndex(int[] nums) {
        // Find the max element.
        int max = findMax(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[max] && nums[i] * 2 > nums[max]) {
                // The largest integer is not eligible.
                return -1;
            }
        }

        return max;
    }

    private int findMax(int[] nums) {
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}