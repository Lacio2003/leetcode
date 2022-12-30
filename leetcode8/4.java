/**
 * Ideas:Some optimizations have been made on the basis of the 3.java file.
 * Time complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int myAtoi(String s) {
        // For easy for use, the length of s is store to the variable n.
        int n = s.length();
        // The position of s.
        int index = 0;

        // Manually remove the spaces yourself.
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // There are no numbers in the string, and 0 is returned directly.
        if (index == n) {
            return 0;
        }

        // The sign is store the sign of the number.
        int sign = 1;
        // The first sign bit is judegd.
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        // The res is store the final answer.
        // The pre stores the last res.
        int res = 0, pre = 0;
        while (index < n) {
            // Get the current character.
            int c = s.charAt(index);
            // Get the number represented by the current character.
            int num = c - '0';
            // If the current character is not a number, return 0 directly.
            if (!Character.isDigit(c)) {
                break;
            }
            // The pre stores the previous res.
            pre = res;
            // Get the current number.
            res = res * 10 + sign * num;
            // If the current number is not equal to pre, the res is overflow.
            if (pre != res / 10) {
                // Return Integer.MAX_VALUE or Integer.MIN_VALUE as appropriate.
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            index++;
        }

        return res;
    }
}