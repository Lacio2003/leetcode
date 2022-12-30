/**
 * 思路：暴力破解，直接使用三个for循环来解决这个问题。
 */

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        // 确定i的位置
        for (int i = 0; i < nums.length; i++) {
            // 确定j的位置
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] == diff) {
                    // 确定k的位置
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] - nums[j] == diff) {
                            // 找到一个三元组
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}