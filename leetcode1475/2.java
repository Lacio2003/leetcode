/**
 * 思路：使用单调栈的思想，从栈顶到栈底为递减序列。(因为我们要寻找比当前元素更小的值)
 * 时间复杂度：O(n)
 * 空间复杂度:O(n)
 */
class Solution {
    public int[] finalPrices(int[] prices) {
        // 为了方便使用，将prices的长度存储起来
        int n = prices.length;
        // 答案数组
        int[] ans = new int[n];
        // 单调栈:元素从栈顶到栈底从大到小。
        Deque<Integer> stack = new LinkedList<>();

        for (int i = n - 1; i >= 0; i--) {
            // 利用单调栈，从栈顶到栈底从大到小排序。
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            // 减去折扣
            ans[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            // 加入当前元素
            stack.push(prices[i]);
        }

        return ans;
    }
}