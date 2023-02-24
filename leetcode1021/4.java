/*
    在上一个的基础上进行优化

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public String removeOuterParentheses(String s) {
        // 准备变量
        int cnt = 0;
        // 存储最后的答案
        StringBuilder ans = new StringBuilder();
        // 开始遍历
        int n = s.length();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                cnt--;
            }
            if (cnt >= 1) {
                ans.append(c);
            }
            if (c == '(') {
                cnt++;
            }
        }

        return ans.toString();
    }
}