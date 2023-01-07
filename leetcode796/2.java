/**
 * website:https://leetcode.cn/problems/rotate-string/solutions/1400369/by-ac_oier-bnkx/
 * Runtime complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    public boolean rotateString(String s, String goal) {
        String string = s + s;
        return s.length() == goal.length() && string.contains(goal);
    }
}