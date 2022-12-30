/**
 * 思路：根据题目的要求，可以得出一个结论：大的数字和大的数字分在一些，小的数字和小的数字分在一起。先对数字进行排序，然后在进行分组，最后求和即可
 * 时间复杂度：O(O(nlogn) + O(n))
 * 空间复杂度：O(1)
 */

class Solution {
    public int arrayPairSum(int[] nums) {
        // 对数组进行排序
        Arrays.sort(nums);

        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            // 因为第一个一定是最小值，所以不用比较了。
            sum += nums[i];
        }
        return sum;
    }
}