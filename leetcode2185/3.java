/**
 * 思路:适用内置函数indexOf()进行判断
 */

class Solution {
    public int prefixCount(String[] words, String pref) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            // 直接使用内置函数进行判断
            if (words[i].indexOf(pref) == 0) {
                ans++;
            }
        }

        return ans;
    }
}