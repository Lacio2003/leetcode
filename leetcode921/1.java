/*
    使用一个栈，遇到左括号入栈，遇到右括号出栈，如果栈是为空或者栈顶是右括号，直接将右括号入栈

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int minAddToMakeValid(String s) {
        // 准备栈
        Deque<Character> stack = new ArrayDeque<>();

        // 开始遍历
        for (char c : s.toCharArray()) {
            if (c == '(') {
                // 遇到左括号
                stack.push(c);
            } else {
                // 遇到右括号
                // 如果栈不为空，并且栈顶是左括号，那么弹出栈顶元素
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                    continue;
                }
                // 栈中没有对应的左括号，说明这个右括号没有左括号可以匹配
                stack.push(c);
            }
        }

        return stack.size();
    }
}