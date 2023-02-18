/*
    website:https://leetcode.cn/problems/find-the-duplicate-number/solutions/261119/xun-zhao-zhong-fu-shu-by-leetcode-solution/

    时间复杂度:O(nlogn)
    空间复杂度:O(1)
*/
class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length, ans = 0;
        int bitMax = 31;

        // 统计最大数字有多少位
        while (((n - 1) >> bitMax) == 0) {
            bitMax--;
        }

        // 开始判断每一位
        for (int bit = 0; bit <= bitMax; bit++) {
            // 统计这一位x和y的个数
            int x = 0, y = 0;
            for (int i = 0; i < n; i++) {
                // 统计nums中数字二进制第i位置为1的个数
                if ((nums[i] & (1 << bit)) != 0) {
                    x++;
                }

                // 统计[1,n]数字二进制i位置上的1的个数
                if (i >= 1 && (i & (1 << bit)) != 0) {
                    y++;
                }
            }

            if (x > y) {
                // 当前位置是
                ans |= 1 << bit;
            }
        }

        return ans;
    }
}