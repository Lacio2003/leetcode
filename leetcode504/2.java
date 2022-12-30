/**
 * Use do while loop omit the special treatment for 0.
 * Runtime complexity:O(logn)
 * Space complexity:O(logn)
 */
class Solution {
    public String convertToBase7(int num) {
        // Convert the num to the positive number.
        int positiveNum = Math.abs(num);
        // The ans stores the final answer.
        StringBuilder ans = new StringBuilder();

        do {
            ans.append(positiveNum % 7);
            positiveNum /= 7;
        } while (positiveNum != 0);

        // The curren number is negative number.
        if (num < 0) {
            ans.append('-');
        }

        return ans.reverse().toString();
    }
}