/*
    website:https://leetcode.cn/problems/volume-of-histogram-lcci/solutions/695146/shuang-zhi-zhen-an-xing-qiu-jie-xiang-xi-d162/

    利用总体积，减去柱子的体积

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int trap(int[] height) {
        // 求柱子的体积
        int postVolume = 0, high = 0;
        for (int e : height) {
            postVolume += e;
            high = Math.max(high, e);
        }

        // 求总体积
        int left = 0, right = height.length - 1; 
        int totalVolume = 0;
        for (int i = 1; i <= high; i++) {
            while (height[left] < i) {
                left++;
            }
            while (height[right] < i) {
                right--;
            }

            totalVolume += right - left + 1;
            left = 0;
            right = height.length - 1;
        }
        
        // 进行相减
        return totalVolume - postVolume;
    }
}