/*
    使用一个栈，寻找每一次原语操作的括号的位置，并把这些位置记录下来，
    然后重新遍历字符串，跳过这些位置就可以了。

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public String removeOuterParentheses(String s) {
        // 准备变量
        Deque<Character> stack = new ArrayDeque<>();
        Set<Integer> positions = new HashSet<>();

        // 开始遍历
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (stack.isEmpty()) {
                    // 遇到外层的左括号
                    positions.add(i);
                }
                stack.push(c);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    // 遇到外层的右括号
                    positions.add(i);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // 跳过外层括号
            if (!positions.contains(i)) {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}