/**
 * Sort the nums first so that the numbers that appear twice must be adjacent.
 * Check the left and the right adjacent digits of the each number if they are not
 * equals to the current number, indicates that this number is unique within the array.
 * Time complexity:O(nlogn + n)
 * Space complexity:O(1)
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        // The ans stores the final answer.
        int[] ans = new int[2];
        // The index of ans.
        int index = 0;
        // Sort the nums.
        Arrays.sort(nums);

        // The length of the nums.
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // Connect arrays to head-to-end.
            /*
            The first way to write it:
            int left = i - 1 < 0 ? len - 1 : i - 1;
            int right = i + 1 >= len ? 0 : i + 1;
            */
            // The second way to write it:
            int left = (i - 1 + len) % len, right = (i + 1) % len;
            if (nums[left] != nums[i] && nums[right] != nums[i]) {
                // The current appears only once in the array.
                ans[index++] = nums[i];
            }
        }

        return ans;
    }
}