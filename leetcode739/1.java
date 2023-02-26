/*
    维持栈底到栈顶单调递减，
    如果栈为空，那么直接将元素入栈，
    如果当前元素比栈顶元素大，那么更新栈顶元素的数组值，并将栈顶元素出栈，重复以上过程，
        直到栈顶的元素的值比它大或者栈为空，然后将当前元素入栈
    如果当前元素<=栈顶元素，直接入栈

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // 准备变量
        int len = temperatures.length;
        int[] ans = new int[len];
        // 栈里面存储的是数组的下标
        Deque<Integer> stack = new ArrayDeque<>();

        // 开始遍历
        for (int i = 0; i < len; i++) {
            // 当前元素大于栈顶元素，不断弹出栈顶元素并进行更新
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }

        return ans;
    }
}