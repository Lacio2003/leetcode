/**
 * 思路：先将数据存入到哈希表当中，然后寻找三元组
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        // 存储数字的hash表
        HashMap<Integer, Integer> hashNums = new HashMap<>();
        // 记录三元组的个数
        int count = 0;

        // 将num当中的数字存入到哈希表当中
        for (int i = 0; i < nums.length; i++) {
            hashNums.put(nums[i], i);
        }

        // 寻找三元组
        for (int i : nums) {
            // 寻找j的值
            int j = diff + i;
            if (hashNums.containsKey(j) && hashNums.get(j) > hashNums.get(i)) {
                // 寻找i的值
                int k = j + diff;
                if (hashNums.containsKey(k) && hashNums.get(k) > hashNums.get(j)) {
                    count++;
                }
            }
        }

        return count;
    }
}