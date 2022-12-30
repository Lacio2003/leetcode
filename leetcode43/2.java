/**
 * Ideas:Optimized on the basis of 1.
 * website:https://leetcode.cn/problems/multiply-strings/solutions/29100/you-hua-ban-shu-shi-da-bai-994-by-breezean/
 * Time comlexity:O(mn) m is the length of num1, n is the length of num2.
 * Space comlexity:O(m + n)
 */
class Solution {
    public String multiply(String num1, String num2) {
        // If one of them is euqal to 0,just return 0.
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        // For easy of use, The length of num1 and num2 is stored variable.
        int len1 = num1.length(), len2 = num2.length();
        // The ans store  the result of multplying two numbers.
        int[] ans = new int[len1 + len2];

        for (int i = len2 - 1; i >= 0; i--) {
            int n2 = num2.charAt(i) - '0';
            for (int j = len1 - 1; j >= 0; j--) {
                int n1 = num1.charAt(j) - '0';
                int sum = ans[i + j + 1] + n1 * n2;
                // Place the product at the specified location.
                ans[i + j + 1] = sum % 10;
                ans[i + j] += sum / 10;
            }
        }

        // Convert array to the string.
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            // The first one requires special treatment.
            if (i == 0 && ans[i] == 0) continue;
            res.append(ans[i]);
        }

        return res.toString();
    }
}