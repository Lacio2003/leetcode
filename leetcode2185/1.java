/**
 * 思路:自己手动写一个方法来判断一个字符串是不是一指定的前缀开头
 * 时间复杂度:O(n^2)
 * 空间复杂度:O(1)
 */

class Solution {
    public int prefixCount(String[] words, String pref) {
        // 存储符合答案的元素
        int ans = 0;
        // 遍历判断每一个字符串
        for (int i = 0; i < words.length; i++) {
            if (check(words[i], pref)) {
                ans++;
            }
        }

        return ans;
    }

    /**
     * 判断一个字符串是不是一个指定的前缀开头
     * @param pref 指定的前缀
     * @param string 要判断的字符串
     * @return 如果是以指定的前缀开头返回true，否则返回false
     */
    private boolean check(String string, String pref) {
        // 如果string的长度比pref小，则string一定不存在前缀pref
        if (string.length() < pref.length()) {
            return false;
        }
        for (int i = 0; i < pref.length(); i++) {
            if (string.charAt(i) != pref.charAt(i)) {
                // 前缀不是pref
                return false;
            }
        }

        // 前缀是pref
        return true;
    }
}