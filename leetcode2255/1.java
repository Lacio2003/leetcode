/**
 * 思路：可以将words中的数据先读入到一个哈希表当中。然后遍历s，依次取出前缀再哈希表当中进行搜索和计数
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */

class Solution {
    public int countPrefixes(String[] words, String s) {
        // 存储words的哈希表
        HashMap<String, Integer> hashWords = new HashMap<>();

        // 将words当中的值存储到哈希表当中
        for (String word : words) {
            hashWords.put(word, hashWords.getOrDefault(word, 0) + 1);
        }

        // 存储最后的答案
        int ans = 0;
        // 为了方便遍历，将s转换为数组
        char[] array = s.toCharArray();
        // 用来拼接s含有的前缀
        StringBuilder prefix = new StringBuilder();
        // 在哈希表当中寻找s的每一个前缀
        for (int i = 0; i < array.length; i++) {
            // 取出当前前缀
            prefix.append(array[i]);
            String currentPrefix = prefix.toString();
            if (hashWords.containsKey(currentPrefix)) {
                // 如果存在前缀则计数
                ans += hashWords.get(currentPrefix);
            }
        }

        return ans;
    }
}