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
        for (int i = len - 1; i >= 0 && carry != 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }

        // A array occurs and the length of the array needs to grow.
        if (carry == 1) {
            int[] ans = new int[len + 1];
            // Copy the data of the orginal array.
            System.arraycopy(digits, 0, ans, 1, len);
            ans[0] = 1;
            return ans;
        }

        return digits;
    }
}