/**
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public boolean checkPerfectNumber(int num) {
        // The ans stores the final answer.
        int ans = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                // The current number is a divisor of num.
                ans += i;
            }
            if (ans > num) {
                // The current number must be not meet the criteria.
                return false;
            }
        }
        
        return ans == num;
    }
}