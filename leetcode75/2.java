/**
 * website:https://leetcode.cn/problems/sort-colors/solutions/437968/yan-se-fen-lei-by-leetcode-solution/
 * 遍历两遍，第一遍将所有的0，移动到开头的位置，第二遍将所有的1，移动到0的后面。
 * 而剩下的部分一定是2。
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
class Solution {
    public void sortColors(int[] nums) {
        int ptr = -1;
        int n = nums.length;

        // 第一遍遍历，将所有的0移动到开头的位置
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                swap(nums, i, ++ptr);
            }
        }

        // 第二遍遍历，将所有的1移动到0的后面
        for (int i = ptr + 1; i < n; i++) {
            if (nums[i] == 1) {
                swap(nums, i, ++ptr);
            }
        }
    }

    /**
     * 交换数组中的两个数字
     */
    private void swap(int[] nums, int a, int b) {
        if (a != b) {
            nums[a] ^= nums[b];
            nums[b] ^= nums[a];
            nums[a] ^= nums[b];
        }
    }
}