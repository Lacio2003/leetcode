/**
 * Ideas:Use dual pointers.
 * 1)Sort the array first.
 * 2)Use the dual pointers to find out the two numbers.
 * Time complexity:O(nlogn)
 * space complexity:O(n)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // For ease of use ,the nums'length is stored in the variable n.
        int n = nums.length;
        // Make a copy of the array to find the subscript later.
        int[] temp = new int[n];
        System.arraycopy(nums, 0, temp, 0, n);

        // Sort the nums array.
        Arrays.sort(nums);

        // Look for numbers that meet the requirements
        int i = 0, j = n - 1;
        while (nums[i] + nums[j] != target) {
            // Greater than target, the right point move to the left.
            while (nums[i] + nums[j] < target) {
                i++;
            }
            // Less than the target, the left point move to the right.
            while (nums[i] + nums[j] > target) {
                j--;
            }
        }

        // The answer's array.
        int[] ans = {-1, -1};
        // Look for the corresponding subscript in the original array.
        for (int k = 0; k < n; k++) {
            if (ans[0] == -1 && temp[k] == nums[i]) {
                ans[0] = k;
            } else if (temp[k] == nums[j]) {
                ans[1] = k;
            }
        }

        return ans;
    }
}