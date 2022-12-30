/**
 * Idea: Use the multipilication vertically.
 * Website:https://leetcode.cn/problems/multiply-strings/solutions/29100/you-hua-ban-shu-shi-da-bai-994-by-breezean/
 * Time complexity:O(mn),m is the length of num1, n is the length of num2.
 * Space complexity:O(m + n)
 */
class Solution {
    public String multiply(String num1, String num2) {
        // If one of the numbers is 0, just then 0.
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        // The res stores the result.
        String res = "";
        for (int j = num2.length() - 1; j >= 0; j--) {
            int n2 = num2.charAt(j) - '0';

            // The cur stores the result of multiplying the current bits.
            StringBuilder cur = new StringBuilder();
            // Supplement zero.
            for (int i = 0; i < num2.length() - 1 - j; i++) {
                cur.append("0");
            }

            // The carry variable.
            int carry = 0;
            // Mutiply every bit of n2 and num1.
            for (int i = num1.length() - 1; i >= 0 || carry != 0; i--) {
                int n1 = i < 0 ? 0 : num1.charAt(i) - '0';
                int product = n1 * n2 + carry;
                cur.append(product % 10);
                carry = product / 10;
            }
            // Add the current result to the previous result.
            res = sumString(res, cur.reverse().toString());
        }

        return res;
    }

    /**
     * Add two numeric strings.
     * @param num1 The first numeric strings.
     * @param num2 The second numeric strings.
     * @return The sum of two numeric strings.
     */
    private static String sumString(String num1, String num2) {
        // The carry variable.
        int carry = 0;
        // The ans stores the sum of two numeric strings.
        StringBuilder ans = new StringBuilder();
        for (int i = num1.length() - 1, j = num2.length() - 1;
             i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int first = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int second = (j >= 0) ? num2.charAt(j) - '0' : 0;
            int sum = first + second + carry;
            ans.append(sum % 10);
            carry = sum / 10;
        }

        return ans.reverse().toString();
    }
 
}