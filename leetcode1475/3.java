/**
 * 思路：也可以使用正序遍历的方式。同时保持栈内从栈顶到栈底递减。
 * 1)如果集合为空，则直接见当前元素加入。
 * 2)如果当前元素比栈顶元素小，则弹出栈顶元素进行更新，直到栈顶元素小于当前元素
 *  并将当前元素压入栈中。
 * note:由于正序遍历比倒序遍历麻烦一点。所以需要我们存储元素的下标。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public int[] finalPrices(int[] prices) {
        // 为了方便使用，将prices的长度存储到变量当中
        int n = prices.length;
        // 答案数组
        int[] ans = new int[n];
        // 单调栈
        Deque<Integer> stack = new LinkedList<>();

        // 正序遍历
        for (int i = 0; i < n; i++) {
            ans[i] = prices[i];
            // 保持栈从上往下递减。
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                ans[index] = prices[index] - prices[i];
            }

            stack.push(i);
        }

        return ans;
    }
}