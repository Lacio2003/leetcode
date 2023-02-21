/*
    使用单调栈来完成这个任务

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peekLast()]) {
                int cur = stack.pollLast();

                // 如果栈为空，那么说明量表没有比这个柱子高的
                if (stack.isEmpty()) {
                    break;
                }

                // 获取高度和宽度
                int l = stack.peekLast(), r = i;
                int w = r - l + 1 - 2;
                int h = Math.min(height[l], height[r]) - height[cur];

                ans += w * h;
            }
            stack.addLast(i);
        }

        return ans;
    }
}