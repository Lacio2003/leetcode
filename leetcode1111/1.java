/*
    遇到左括号，如果栈为空，那么赋值1或者0都可以，如果栈不为空，和上一位相反。

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        // 准备栈
        Deque<Integer> stack = new ArrayDeque<>();
        int n = seq.length();
        // 存储答案的数组
        int[] ans = new int[n];

        // 开始遍历
        for (int i = 0; i < n; i++) {
            char c = seq.charAt(i);
            if (c == '(') {
                // 遇到左括号
                // 如果栈为空，那么赋值1或者0都可以。
                // 如果栈不为空，为了保证深度最小，那么就需要和外层括号的值是相反的
                ans[i] = stack.isEmpty() ? 1 : (ans[stack.peek()] == 0 ? 1 : 0);
                stack.push(i);
            } else {
                // 遇到右括号，看对应的左括号就可以了。
                ans[i] = ans[stack.pop()];
            }
        }

        return ans;
    }
}