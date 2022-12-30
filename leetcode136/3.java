/**
 * a ^ a = 0;Therefore, the number that appears twice will automatically cancel out, and the remainder number that appears once.
 * Time complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int singleNumber(int[] nums) {
        // The ans stores the final answer.
        int ans = 0;
        for (int e : nums) {
            ans ^= e;
        }

        return ans;
    }
}