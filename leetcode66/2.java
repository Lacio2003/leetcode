/**
 * Perform the required operation, paying the attention to the carry problem.
 * Time complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    public int[] plusOne(int[] digits) {
        // The carry variable.
        int carry = 1;
        // The length of the digits.
        int len = digits.length;

        // Perform the add one operation.
        for (int i = len - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;

            // No simailar situation occurred with 9 + 1 = 10.
            if (carry == 0) {
                return digits;
            }
        }

        // The program can executed, there is a situation simailar to 9 + 1 = 10.
        // Explain that the original number is 9 or 99, 999, .....
        digits = new int[len + 1];
        digits[0] = 1;
        return digits;
    }
}