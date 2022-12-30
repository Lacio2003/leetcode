/**
 * 思路：使用Java中内置的startsWith()来判断前缀。
 * 遍历words,使用startsWith()来判断当前字符串是不是s的前缀
 * 时间复杂度：O(mn)
 * 空间复杂度：O(1)
 */

class Solution {
    public int countPrefixes(String[] words, String s) {
        // 记录前缀的个数
        int count = 0;

        // 遍历words
        for (int i = 0; i < words.length; i++) {
            // 判断当前字符串是不是s的前缀。
            if (s.startsWith(words[i])) {
                count++;
            }
        }

        return count;
    }
}