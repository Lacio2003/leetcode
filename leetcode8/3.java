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

        // The rest is store the final answer.
        int res = 0;
        while (index < n) {
            // Get the current character.
            int c = s.charAt(index);
            // Get the number represented by the current character.
            int num = c - '0';
            // If the current character is not a number, return 0 directly.
            if (!Character.isDigit(c)) {
                break;
            }

            // Determine if the current number is greater than Integer.MAX_VALUE.
            if (res > (Integer.MAX_VALUE / 10) || (res == Integer.MAX_VALUE / 10 && (num > (Integer.MAX_VALUE % 10)))) {
                // If the current number is greater tham Integer.MAX_VALUE, return Integer.MAX_VALUE directly.
                return Integer.MAX_VALUE;
            }

            // Determine if the current number is less than the Integer.MIN_VALUE.
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && num > -(Integer.MIN_VALUE % 10))) {
                // If the current number is less than the Integer.MIN_VALUE, return Integer.MIN_VALUE directly.
                return Integer.MIN_VALUE;
            }

            // The program can executed here, indicatin that adding the current number will not cross the boundary, add the current number to the res.
            res = res * 10 + sign * num;
            index++;
        }

        return res;
    }
}