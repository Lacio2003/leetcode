/**
 * website:https://leetcode.cn/problems/longest-uncommon-subsequence-i/solutions/1306210/zui-chang-te-shu-xu-lie-i-by-leetcode-so-v9sr/
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}