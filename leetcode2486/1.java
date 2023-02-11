/*
    找到第一次包含t字符的地方。然后指针同时移动，最后返回结果解可以了。

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int appendCharacters(String s, String t) {
        int p = 0, n = t.length();
        for (char c : s.toCharArray()) {
            if (c == t.charAt(p)) {
                p++;
            }

            if (p == n) {
                return 0;
            }
        }

        return n - p;
    }
}