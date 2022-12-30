/**
 * The second method
 * website:https://leetcode.cn/problems/gray-code/solutions/9730/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--12/
 * Time complexity:O(2^n)
 * Space complexity:O(1)
 */
class Solution {
    public List<Integer> grayCode(int n) {
        // The ans stores the gray code.
        List<Integer> ans = new ArrayList<>();
        ans.add(0);

        // The previous gray code.
        int pre = 0;
        for (int i = 1; i < (1 << n); i++) {
            // By default, the first action is preformed.
            int next = pre ^ 1;
            // The second action is preformed.
            if ((i & 1) == 0) {
                // Look for the 1 on the far right.
                int j = 1;
                while ((j & pre) == 0) {
                    j <<= 1;
                }
                // Change the position of the left-hand of the rightmost 1.
                next = pre ^ (j << 1);
            }
            ans.add(next);
            pre = next;
        }

        return ans;

    }
}