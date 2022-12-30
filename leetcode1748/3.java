/**
 * 思路:相比于1中的哈希表进行了优化，只使用了一次遍历。
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 */

class Solution {
    public int sumOfUnique(int[] nums) {
        // 存储结果的哈希表
        Map<Integer, Integer> map = new HashMap<>();

        // 存储最后的结果
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                // 哈希表当中存在当前元素
                if (map.get(nums[i]) != 0) {
                    // 哈希表加入过这种元素，所以，现在需要减去
                    ans -= nums[i];
                    map.put(nums[i],0);
                }
            } else {
                // 哈希表不存在这种元素
                ans += nums[i];
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            } 
        }

        return ans;
    }
}