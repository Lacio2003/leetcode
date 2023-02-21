/*
    website:https://leetcode.cn/problems/container-with-most-water/solutions/11491/container-with-most-water-shuang-zhi-zhen-fa-yi-do/

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int maxArea(int[] height) {
        // 准备变量
        int left = 0, right = height.length - 1;
        // 开始遍历
        int ans = 0;
        while (left <= right) {
            ans = height[left] < height[right] ? 
                Math.max(ans, (right - left) * height[left++]):
                Math.max(ans, (right - left) * height[right--]);
        }

        return ans;
    }
}