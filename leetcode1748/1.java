/**
 * 思路:利用哈希表可以去重的特点，对数组进行去重。
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 */

class Solution {
    public int sumOfUnique(int[] nums) {
        // 将nums中的元素存储到一个哈希表当中
        // k为元素值,value为元素在数组当中出现的次数
        Map<Integer, Integer> map = new HashMap<>();

        for (int e : nums) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        int ans = 0;
        // 遍历求和
        for (Map.Entry<Integer,Integer> e : map.entrySet()) {
            ans += (e.getValue() == 1) ? e.getKey() : 0;
        }

        return ans;
    }
}