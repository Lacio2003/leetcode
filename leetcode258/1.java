/**
 * Use circular brute force according to the topic.
 * Time complexity:O(n^2),n is the number of digits of the num.
 * Space complexity:O(1)
 */
class Solution {
    public int addDigits(int num) {
        while (num > 9) {
            int cur = 0;
            // The sum of all digits of the current digit.
            while (num > 0) {
                cur += (num % 10);
                num /= 10;
            }
            num = cur;
        }

        return num;
    }
}