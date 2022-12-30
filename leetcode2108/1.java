/**
 * 思路：暴力破解，直接遍历数组，判断每一个字符串是不是回文串
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */

class Solution {
    public String firstPalindrome(String[] words) {
        for (String s : words) {
            // 判断是否是回文串，如果是直接返回
            if (check(s.toCharArray())) {
                return s;
            }
        }

        // 不是回文串，直接返回空串
        return "";
    }

    /**
     * @param chars要判断的字符串
     * @return 如果是一个回文串，返回tre，否则返回false
     */
    private boolean check(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            // 判断前面的字符串和后面的字符串是否相等
            if (chars[i] != chars[chars.length - 1 - i]) {
                // 不是回文串，直接返回
                return false;
            }
        }
        return true;
    }
}