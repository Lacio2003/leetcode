/**
 * 思路：转换问题，最后的答案一定为数组当中两个最大值的乘积。所以，问题转化为在数组当中寻找第一大的值和第二大的值
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */

class Solution {
    public int maxProduct(int[] nums) {
        // 存储最大值和次大值
        int firstMax = nums[0], secondMax = Integer.MIN_VALUE;

        // 遍历寻找最大值
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                // 找到新的最大值，需要将firstMax赋值给次大值
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (nums[i] > secondMax) {
                // 找到新的次大值
                secondMax = nums[i];
            }
        }

        // 返回结果
        return (firstMax - 1) * (secondMax - 1);
    }
}