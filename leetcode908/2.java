/**
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        // 获取最大值和最小值
        int[] maxMin = findMaxMin(nums);
        int max = maxMin[0], min = maxMin[1];

        //返回结果
        int ans = max - k - (min + k);
        return ans < 0 ? 0 : ans;
    }

    /**
     * 在数组中寻找最大值和最小值
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param nums 要寻找的数组
     * @return 最大值和最小值。第一个是最大值，第二个是最小值。
     */
    private int[] findMaxMin(int[] nums) {
        // 存储最大值和最小值
        int max = nums[0], min = nums[0];
        // 遍历找出最大值和最小值
        for (int i = 1; i < nums.length; i++) {
            // 更新最大值
            max = nums[i] > max ? nums[i] : max;
            // 更新最小值
            min = nums[i] < min ? nums[i] : min;
        }

        // 返回最大值和最小值
        return new int[]{max, min};
    }
}