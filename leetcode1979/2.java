/**
 * 思路:先找打数组当中的最大值和最小值，然后寻找最大值和最小值的最大公约数
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 * 优化方案:对寻找最大公约数进行优化，这里寻找最大公约数的时间复杂度为O(n)，可以利用数学知识将
 * 时间复杂度将为O(1)
 */
class Solution {
    public int findGCD(int[] nums) {
        // 找到数组当中的最大值和最小值
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 更新最大值
            max = nums[i] > max ? nums[i] : max;
            // 更新最小值
            min = nums[i] < min ? nums[i] : min;
        }

        // 找到最大公约数
        int maxDivisor = 1;
        for (int i = 2; i <= min; i++) {
            if (min % i == 0 && max % i == 0) {
                maxDivisor = i;
            }
        }

        return maxDivisor;
    }
}