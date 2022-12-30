/**
 * 思路：按照题目的要求，对数组进行遍历，依次遍历递增既可。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public int minOperations(int[] nums) {
        // 存储最后的答案
        int ans = 0;
        // 遍历并适当对数组进行递增
        for (int i = 1; i < nums.length; i++) {
            // 如果并非递增，进行递增操作，并记录数组
            if (nums[i] <= nums[i - 1]) {
                int increaValue = nums[i - 1] - nums[i] + 1;
                ans += increaValue;
                nums[i] += increaValue;
            }
        }

        return ans;
    }
}