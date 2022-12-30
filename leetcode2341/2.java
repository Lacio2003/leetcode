/**
 * 思路：使用数组的频数数组，来记录出现的次数的值。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */

class Solution {
    public int[] numberOfPairs(int[] nums) {
        // 用来记录数字的次数
        int[] count = new int[101];
        // 用来记录数对的次数
        int ans = 0;

        // 遍历nums查找数对
        for (int e : nums) {
            count[e]++;
            if (count[e] == 2) {
                // 找到一个数对，因为每次我们都会进行检验，所以直接赋值0即可
                count[e] = 0;
                ans++;
            }
        }

        return new int[]{ans, nums.length - 2 * ans};
    }
}