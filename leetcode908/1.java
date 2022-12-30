/**
 * 思路：按照题目要求，最后的结果一定等于max- k - (min + k)。所以，我们可以先
 * 对数组进行排序，找出最大值然后返回结果即可。
 * 时间复杂度：O(nlogn)，排序花费的时间。
 * 空间复杂度：O(1)
 */
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        // 对数组排序
        Arrays.sort(nums);
        // 找出最大值和最小值
        int min = nums[0], max = nums[nums.length - 1];
        // 按照题目要求，返回最大值和最小值的差值
        int ans = max - k - min - k;
        // 如果差值为负值，符合题目的差值一定是0.
        return ans < 0 ? 0 : ans;
    }
}