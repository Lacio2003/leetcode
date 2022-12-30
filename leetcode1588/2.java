/**
 * 思路：利用前缀和来计算前缀的子数组的和。然后进行加总。
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 */

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        // 前缀和数组
        int[] perfix = new int[n + 1];

        // 计算前缀和
        for (int i = 1; i <= n; i++) {
            perfix[i] = arr[i - 1] + perfix[i - 1];
        }


        // 计算最后的结果
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // 计算奇数子数组的和
            for (int start = 1; start + i - 1 < n; start += 2) {
                // 因为perfix整体往右移了1位，所以不需要减一
                sum += perfix[i + start] - perfix[i];
            }
        }

        return sum;
    }
}