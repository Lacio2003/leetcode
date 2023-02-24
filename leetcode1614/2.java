/*
    不使用栈，进行统计

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int maxDepth(String s) {
        int cnt = 0, ans = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                cnt++;
                ans = Math.max(ans, cnt);
            } else  if (c == ')') {
                cnt--;
            } else {
                continue;
            }
        }

        return ans;
    }
}