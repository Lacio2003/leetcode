/**
 * Recursion implementation.
 * Time complexity:O(n^2).n is the number of all digits of the num.
 * Spcae complexity:O(n)
 */
class Solution {
    public int addDigits(int num) {
        // The end condition of num.
        if (num <= 9) {
            return num;
        }
        // The sum of all digits of the current number.
        int cur = 0;
        while (num > 0) {
            cur += num % 10;
            num /= 10;
        }

        return addDigits(cur);
    }
}