/**
 * 思路：先对数组进行排序，然后返回数组当中的两个最大值即可
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(i)
 */

class Solution {
    public int maxProduct(int[] nums) {
        // 对数组进行排序，然后寻找
        Arrays.sort(nums);

        int n = nums.length;
        // 直接返回最大的两个值的乘积
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }
}