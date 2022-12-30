/**
 * website:https://leetcode.cn/problems/perfect-number/solutions/1179051/wan-mei-shu-by-leetcode-solution-d5pw/
 * Runtime complexity:O( 根号num)
 * Space complexity:O(1)
 */
class Solution {
    public boolean checkPerfectNumber(int num) {
        // 1 special handing reuqired.
        if (num == 1) {
            return false;
        }

        // The ans stores the final answer.
        int ans = 1;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                ans += i;
                // The factor corresponding to i.
                if (i * i != num) {
                    ans += num / i;
                }
            }
        }

        return ans == num;
    }
}