/**
 * Idea:Let's first remove the head space in the string. In this way,there are only three possibilities for the first bit.It could be number, sign and other.If the first bit is the sign, we update the sign variable.If the first bit is number, we update the ans,otherwise, we break the loop.
 * In order to write code better.We handle the situation where the first bit is a sign.
 * Time complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int myAtoi(String s) {
        // Remove the head space from the string.
        s = s.trim();
        // For easy for use, The length of s is stored to a variable n.
        int n = s.length();
        // If the length of s is equal to 0, return directly.
        if (n == 0) {
            return 0;
        }

        // The ans store the number.
        long ans = 0;
        // The sign of the ans.
        int sign = 1;
        // The position of the s.
        int i = 0;
        // Judge the first place.
        if (s.charAt(i) == '-' || s.charAt(i) == '+') {
            sign = s.charAt(i) == '+' ? 1 : -1;
            i = 1;
        }

        // Traversal the string.
        while (i < n) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                // If the current character is number, take it out.
                ans = ans * 10 + c - '0';
                ans = sign == 1 ? Math.min((long)Integer.MAX_VALUE, ans) : Math.min(-(long)Integer.MIN_VALUE, ans);
            } else {
                // As long as it's not a number, stop the loop.
                break;
            }
            i++;
        }

        // Return the ans.
        return (int)(ans * sign);
    }
}