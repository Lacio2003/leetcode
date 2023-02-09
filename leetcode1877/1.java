/*
    先对数组排序，然后头和尾两两相加
    时间复杂度:O(nlogn)
    空间复杂度:O(1)
*/
class Solution {
    public int minPairSum(int[] nums) {
        // 1.准备变量
        int ans = 0;
        int n = nums.length;
        // 2.排序
        Arrays.sort(nums);
        // 3.两两相加
        for (int head = 0, tail = n - 1; head < tail; head++, tail--) {
            ans = Math.max(nums[head] + nums[tail], ans);
        }

        return ans;
    }
}