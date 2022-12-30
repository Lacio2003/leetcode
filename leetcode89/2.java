/**
 * The n gray code:n ^ (n >> 1)
 * Time complexity:O(2^n)
 * Space complexity:O(1)
 */
class Solution {
    public List<Integer> grayCode(int n) {
        // The ans stores the gray code.
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < (1 << n); i++) {
            // Solve according to the formula.
            ans.add(i ^ (i >> 1));
        }

        return ans;
    }
}