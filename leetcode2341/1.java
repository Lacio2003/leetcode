/**
 * 思路：可以将nums中的数字读取到HashMap。利用HashMap的key和value来解决问题。
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */

class Solution {
    public int[] numberOfPairs(int[] nums) {
        // key存储当前元素，value存储当前元素出现的次数。
        Map<Integer, Integer> hashNums = new HashMap<>();

        // 存储相等数对的数目
        int ans = 0;
        for (int e : nums) {
            // 将元素以及出现的此处加入HashMap当中
            hashNums.put(e, hashNums.getOrDefault(e, 0) + 1);
            // 检查是否有数对
            if (hashNums.get(e) == 2) {
                // 移除元素
                hashNums.remove(e);
                ans++;
            }
        }

        // 剩余元素的个数就是HashMap的大小
        return new int[]{ans, hashNums.size()};
    }
}