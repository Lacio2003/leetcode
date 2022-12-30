/**
 * Convert base 26 to decimal.
 * Time complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int titleToNumber(String columnTitle) {
        // The ans stores the final answer.
        int ans = 0;
        // For easy of use, the length of columnTitle is stored in a variable.
        int len = columnTitle.length();
        for (int i = 0; i < len; i++) {
            // Get the current number.
            int cur = columnTitle.charAt(i) - 'A' + 1;
            // Convert to decimal.
            ans = ans * 26 + cur;
        }

        return ans;
    }
}