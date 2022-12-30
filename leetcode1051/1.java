/**
 * 暴力破解：使用两个数组。一个存放排序之前的数组，另一个排放排序之后的数组。然后使用循环进行对比即可。
 * 时间复杂度：O(nlog(n))
 * 空间复杂度：O(n)
 */

class Solution {
    public int heightChecker(int[] heights) {
        // 为了方便使用数组的长度，使用一个变量进行存储。
        int n = heights.length;
        // 复制一个新的数组，该数组存放排序之前的元素
        int[] newArray = Arrays.copyOf(heights, n);

        // 将原来的数组进行排序
        Arrays.sort(heights);

        // 存放不同元素的个数
        int ans = 0;
        // 将排序之前的数组和排序之后的数组进行对比
        for (int i = 0; i < n; i++) {
            // 不同的元素ans++
            if (heights[i] != newArray[i]) {
                ans++;
            }
        }

        return ans;
    }
}