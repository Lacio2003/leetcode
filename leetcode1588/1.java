/**
 * 思路：使用暴力破解的方法。遍历每一个位置，计算以每一个位置开头的奇数数组的和。
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        // 最后的结果
        int ans = 0;
        // 遍历每一个位置
        for (int i = 0; i < arr.length; i++) {
            // 子数组的和
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                // 如果这个子数组是奇数子数组，则加到最后的结果当中
                if (((j - i + 1) & 1) == 1) {
                    ans += sum;
                }
            }
        }

        return ans;
    }
}