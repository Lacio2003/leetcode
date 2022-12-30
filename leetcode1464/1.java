/**
 * 思路：暴力破解
 * 时间复杂度：O(n^2)
 * 空间复杂度:O(1)
 */

class Solution {
    public int maxProduct(int[] nums) {
        // 存储最大值
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 找到更大的值进行替换
                if ((nums[i] -1) * (nums[j] - 1) > max) {
                    max = (nums[i] - 1) * (nums[j] - 1);
                }
            }
        }

        return max;
    }
}