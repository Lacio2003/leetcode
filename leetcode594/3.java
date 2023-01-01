/**
 * website:https://leetcode.cn/problems/longest-harmonious-subsequence/solutions/1111541/gong-shui-san-xie-yi-ti-shuang-jie-hua-d-quuh/
 * Runtime complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    public int findLHS(int[] nums) {
        // i stores each digit and its corresponding number of occurrences
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // The ans stores the final answer.
        int ans = 0;
        for (int i : nums) {
            if (map.containsKey(i - 1)) {
                ans = Math.max(ans, map.get(i) + map.get(i - 1));
            }
        }

        return ans;
    }
}