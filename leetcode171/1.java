/**
 * Convert base 26 to decimal.
 * Time complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int titleToNumber(String columnTitle) {
        // The ans stores the final answer.
        int ans = 0;
        for (int i = columnTitle.length() - 1, n = 1; i >= 0; i--, n *= 26) {
            // Get the current number.
            int cur = columnTitle.charAt(i) - 'A' + 1;
            // Convert to decimal.
            ans += cur * n;
        }

        return ans;
    }
}