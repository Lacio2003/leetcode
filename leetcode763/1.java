/*
    如何尽可能划分为多个片段
        尽可能小范围的遍历
    如何满足同一字母出现在同一片段里面
        可以通过记录每一个字母出现的结束的位置下
    思路:
        记录字符串中每一个字符出现的结束位置
        使用两个指针表示片段的范围，end = Math.max(当前字符的结束位置，end)。
*/
class Solution {
    public List<Integer> partitionLabels(String s) {
        // 记录所有字符出现的最后位置
        int[] last = new int[26];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        // 遍历字符串切成片段
        int start = 0, end = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                // 说明这是一个片段，并且字母没有再后面出现过
                ans.add(end - start + 1);
                start = end + 1;
            }
        }

        return ans;
    }
}