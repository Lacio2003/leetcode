/**
 * Calculations are performed using decimal rules.
 * Time complexity:O(log26)
 * Space complexity:O(log26)
 */
class Solution {
    public String convertToTitle(int columnNumber) {
        // The ans stores the final answer.
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            // Prevent the occurrence of a situation that is exactly 26.
            columnNumber--;
            // Get the final answer.
            char cur = (char)(columnNumber % 26 + 'A');
            ans.append(cur);
            columnNumber /= 26;
        }

        return ans.reverse().toString();
    }
}