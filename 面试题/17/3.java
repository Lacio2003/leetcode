/*
    在上一个的基础商降低复杂度，提前将左右的最高度存储近数组

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int trap(int[] height) {
        // 排除一些情况
        int n = height.length;
        if (n < 2) {
            return 0;
        }
        // 求左边的最高度
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        // 求右边的最高度
        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // 遍历求和
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }
}