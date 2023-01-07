/**
 * Runtime complexity:O(n - 1)
 * Space complexity:O(s.length())
 */
class Solution {
    public boolean rotateString(String s, String goal) {
        // For easy of use, the length of goal is stored in a variable.
        int len = s.length();
        // Stores the String s.
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int i = 0; i < len - 1 && !goal.equals(stringBuilder.toString()); i++) {
            // Shift the s.
            char cur = stringBuilder.charAt(0);
            stringBuilder.deleteCharAt(0);
            stringBuilder.append(cur);
        }

        return goal.equals(stringBuilder.toString());
    }
}