/**
 * website:https://leetcode.cn/problems/gray-code/solutions/1198215/gong-shui-san-xie-dui-cheng-xing-gou-zao-9ap1/
 * Time complexity:O(2^n)
 * Space complexity:O(1)
 */
class Solution {
    public List<Integer> grayCode(int n) {
        // The ans stores the gray code.
        List<Integer> ans = new ArrayList<>();
        // Initialize the gray code.
        ans.add(0);

        while (n --> 0) {
            // Get the k+1 for gray code.
            for (int i = ans.size() - 1; i >= 0; i--) {
                // Because the k+1 is a gray code, shift to the left.
                ans.set(i, ans.get(i) << 1);
                ans.add(ans.get(i) + 1);
            }
        }

        return ans;
    }
}