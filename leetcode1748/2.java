/**
 * 思路:根据题目可得出:一个数组排序之后，重复元素一定是挨着的，所以，可以先对数组进行排序。 然后进行遍历。
 * 时间复杂度:O(nlogn + n)
 * 空间复杂度:O(1)
 */

class Solution {
    public int sumOfUnique(int[] nums) {
        // 为了方便使用，将数组的长度存储到一个变量nums当中
        int n = nums.length;
        // 先对数组进行排序
        Arrays.sort(nums);

        // 存储答案
        int ans = 0;
        for (int i = 0; i < n; i++) {
            // 当前元素的左右下标
            int left = (i - 1 + n) % n, right = (i + 1) % n;
            ans += (left != right && (nums[i] == nums[left] || nums[i] == nums[right])) ? 0 : nums[i];
        }

        return ans;
    }
}