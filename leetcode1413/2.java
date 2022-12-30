/**
 * 思路：贪心思想。求出累加和的最小值。那么只要让最小值大于0即可。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public int minStartValue(int[] nums) {
        // minSum存储累加和的最小值
        // sum存储累加和
        int minSum = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            minSum = Math.min(sum, minSum);
        }

        // 只要让累加和的最小值满足大于0即可。
        return -minSum + 1;
    }
}