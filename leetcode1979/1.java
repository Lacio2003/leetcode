/**
 * 思路:先对数组进行排序找出最大值(max)和最小值(min)。由于max和min的最大公约数一定在1~min之间，所以一个一个的遍历尝试即可。
 * 时间复杂度:O(nlogn + n)
 * 空间复杂度:O(1)
 */
class Solution {
    public int findGCD(int[] nums) {
        // 先对数组进行排序，找出最小的数字和最大的数字
        Arrays.sort(nums);

        // 为了方便使用，将nums的长度存储到n当中
        int n = nums.length;
        // 最小的数字和最大的数字
        int min = nums[0], max = nums[n - 1];

        // 最大公约数
        int maxDivisor = 1;
        // 两个数的最大公约数一定在0~max之间，可以通过循环一个一个的试
        for (int i = 2; i <= min; i++) {
            if (min % i == 0 && max % i == 0) {
                // 由于i的值是递增的，所以，用不着判断大小。
                maxDivisor = i;
            }
        }

        return maxDivisor;
    }
}