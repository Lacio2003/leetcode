/**
 * website:https://leetcode.cn/problems/gray-code/solutions/13637/gray-code-jing-xiang-fan-she-fa-by-jyd/
 * Time complexity:O(2^n)
 * Space complexity:O(1)
 */
class Solution {
    public List<Integer> grayCode(int n) {
        // The ans stores the gray code.
        List<Integer> ans = new ArrayList<>();
        // The gray code of the first order.
        ans.add(0);

        // The position of xor 1.
        int head = 1;
        for (int i = 0; i < n; i++) {
            // Get the n order.
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(ans.get(j) ^ head);
            }
            head <<= 1;
        }

        return ans;
    }
}