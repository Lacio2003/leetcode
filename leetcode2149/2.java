/*
    直接创建一个新的数组，原来的正数存放在偶数位置，负数存放在奇数位置
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int[] rearrangeArray(int[] nums) {
        // 准备变量
        int i = 0, j = 1, n = nums.length;
        int[] ans = new int[n];

        // 遍历nums
        for (int e : nums) {
            if (e > 0) {
                ans[i] = e;
                i += 2;
            } else {
                ans[j] = e;
                j += 2;
            }
        }

        return ans;
    }
}