/**
 * 思路：暴力破解。遍历数组。使用一个sum来存储nums的和， 使用一个ans来。如果sum小于num。那么对sum和ans进行加加操作。最后返回结果即可。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public int minStartValue(int[] nums) {
        // ans是开始的正数，sum代表加和的操作。
        int ans = 1, sum = 1;
        for (int num : nums) {
            // 如果结果是负数，则进行++操作
            while (sum + num <= 0) {
                sum++;
                ans++;
            }
            sum += num;
        }

        return ans;
    }
}