/*
    使用栈，遇到非括号，直接跳过，遇到左括号压入栈，并更新最后答案

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int maxDepth(String s) {
        // 准备栈
        Deque<Character> stack = new ArrayDeque<>();

        // 开始遍历
        int ans = 0;
        for (char c : s.toCharArray()) {
            // 遇到不是括号，直接跳过
            if (c != '(' && c != ')') {
                continue;
            }

            if (c == '(') {
                // 遇到左括号，压栈
                stack.push(c);
                // 更新最后答案
                ans = Math.max(ans, stack.size());
            } else {
                stack.pop();
            }
        }

        return ans;
    }
}