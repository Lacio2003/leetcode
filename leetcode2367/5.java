/**
 * 思路：三指针法
 * 1.先确定k的位置
 * 2.确定j的位置
 * 3.确定i的位置
 * 之所以从右往左确定而不是从左往右确定，是因为从左往右确定程序右许多限制和漏洞。
 */

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        // 统计三元组的数目
        int count = 0;
        // i代表三元组中的i，j代表三元组中的j
        int i = 0, j = 0;
        for (int k : nums) {
            // 确定j的位置
            while (nums[j] + diff < k) {
                j++;
            }
            // 确定i的位置
            while (nums[i] + diff < nums[j]) {
                i++;
            }
            // 判断是否找到一个三元组
            if (nums[i] + diff == nums[j] && nums[j] + diff == k) {
                count++;
            }
        }

        return count;
    }
}