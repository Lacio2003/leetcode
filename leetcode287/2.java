/*
    website:https://leetcode.cn/problems/find-the-duplicate-number/solutions/7038/er-fen-fa-si-lu-ji-dai-ma-python-by-liweiwei1419/
    二分法+统计数字。
    利用二分法一个一个猜数字，然后统计数组里面小于mid的数字的个数，如果比这个数字大，说明在重复的数字在[left,mid]中，否则就在[mid+1,right]中。

    时间复杂度:O(nlogn)
    空间复杂度:O(1)
*/
class Solution {
    public int findDuplicate(int[] nums) {
        // 准备变量
        int n = nums.length;
        int left = 1, right = n - 1;
        // 开始二分查找
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            // 记录小于等于mid的个数
            int count = 0;
            for (int e : nums) {
                if (e <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}