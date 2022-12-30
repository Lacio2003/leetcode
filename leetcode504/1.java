/**
 * Runtime complexity:O(logn)
 * Space complexity:O(logn)
 */
class Solution {
    public String convertToBase7(int num) {
        // Special handing of 0.
        if (num == 0) {
            return "0";
        }

        // Make num positive.
        int number = Math.abs(num);
        // The ans stores the final answer.
        StringBuilder ans = new StringBuilder();
        while (number != 0) {
            int cur = number % 7;
            ans.append(cur);
            number /= 7;
        }

        if (num < 0) {
            // The current number is negative number.
            ans.append('-');
        }

        return ans.reverse().toString();
    }
}