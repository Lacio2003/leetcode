/*
    暴力破解

    遍历每一个柱子，寻找这个柱子左右两边的最大值，然后取最小的和当前的柱子做差
    边缘的柱子不用检查，因为不可以能接到雨水

    时间复杂度:O(n^2)
    空间复杂度:O(1)
*/
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            // 寻找当前柱子左边的最大值
            int leftMax = 0;
            for (int j = i - 1; j > -1; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            // 寻找当前柱子右边的最大值
            int rightMax = 0;
            for (int k = i + 1; k < n; k++) {
                rightMax = Math.max(rightMax, height[k]);
            }

            // 如果其中一个柱子比当前柱子低，那么停止循环
            if (leftMax < height[i] || rightMax < height[i]) {
                continue;
            }

            ans += Math.min(leftMax, rightMax) - height[i];
        }

        return ans;
    }
}