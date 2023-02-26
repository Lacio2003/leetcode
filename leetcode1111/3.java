/*
    在上一个的基础上进行代码的简化

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            // ans[i] = 1 & (c == '(' ? i : i - 1);
            ans[i] = (c ^ i) & 1;
        }

        return ans;
    }
}