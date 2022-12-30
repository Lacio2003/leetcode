/**
 * Idea:Reverse the number and check if the numbers cross the line at all times during the reversal.
 * Time complexity:O(logN)
 * Space complexity:O(1)
 */
class Solution {
    public int reverse(int x) {
        // The reverseNum storage the reverse number.
        int reverseNum = 0;
        // Divide by the last digit to stop.
        while (x != 0) {
            // Determine whether the number after the reversal is out of bounds.
            if (reverseNum < (Integer.MIN_VALUE / 10) || reverseNum > (Integer.MAX_VALUE / 10)) {
                return 0;
            }
            // Reverse the number.
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }

        // Return the reversal number.
        return reverseNum;
    }
}