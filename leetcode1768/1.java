/*
    使用两个指针同时指向两个字符串，先后进行合并
    时间复杂度:O(n + m)
    空间复杂度:O(n + m)
*/
class Solution {
    public String mergeAlternately(String word1, String word2) {
        // 准备变量
        StringBuilder ans = new StringBuilder();

        // 遍历两个字符串
        int i = 0, j = 0;
        int len1 = word1.length(), len2 = word2.length();

        for (int k = 0; i < len1 && j < len2; k++) {
            if ((k & 1) == 0) {
                ans.append(word1.charAt(i++));
            } else {
                ans.append(word2.charAt(j++));
            }
        }

        // 读取剩余的部分
        while (i < len1) {
            ans.append(word1.charAt(i++));
        }

        while (j < len2) {
            ans.append(word2.charAt(j++));
        }

        return ans.toString();
    }
}