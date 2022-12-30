/**
 * 思路：先将nums中的数组存储到哈希表当中，然后利用哈希表判断j和k是否存在。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        // 存储nums的哈希表
        int[] hash = new int[251];

        // 将nums中的数字存储到哈希表当中
        for (int e : nums) {
            hash[e]++;
        }

        // 统计三元组的个数
        int count = 0;
        // 遍历nums，寻找三元组的个数
        for (int i : nums) {
            // 确定是否存在j和k
            if (hash[i + diff] != 0 && hash[i + diff + diff] != 0) {
                count++;
            }
        }

        return count;
    }
}