/**
 * Sort the the array first.Then look for 0 to n, look for one by one in the nums.
 * Time complexity:O(nlogn + n)
 * Space complexity:O(1)
 */
class Solution {
    public int missingNumber(int[] nums) {
        // Sort the nums.
        Arrays.sort(nums);

        // For easy of use, the length of nums is stored in a variable.
        int len = nums.length;
        // The ans stores the missing number.
        int ans = len;
        for (int i = 0; i < len; i++) {
            if (i != nums[i]) {
                // The current number is missing number.
                ans = i;
                break;
            }
        }

        // If not found in the array, then the missing number is len.
        return ans;
    }
}