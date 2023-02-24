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
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            ans.append(c);
            if (c == '(') {
                if (cnt == 0) {
                    // 遇到外层的左括号
                    ans.deleteCharAt(ans.length() - 1);
                }
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    // 遇到外层的右括号
                    ans.deleteCharAt(ans.length() - 1);
                }
            }
        }

        return ans.toString();
    }
}