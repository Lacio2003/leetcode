/*
    在1的基础上进行代码的优化
    时间复杂度:O(n + m)
    空间复杂度:O(n + m)
*/
class Solution {
    public String mergeAlternately(String word1, String word2) {
        // 准备变量
        int len1 = word1.length(), len2 = word2.length();
        StringBuilder sb = new StringBuilder();

        // 遍历字符串
        for (int i = 0, j = 0; i < len1 || j < len2;) {
            if (i < len1) {
                sb.append(word1.charAt(i++));
            }

            if (j < len2) {
                sb.append(word2.charAt(j++));
            }
        }

        return sb.toString();
    }
}