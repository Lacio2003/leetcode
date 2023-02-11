/*
    双指针，
    一个指针用来表示偶数的边界，另一个指针用来寻找偶数
    如果当前数字是一个偶数，那么和偶数的边界的下一个数字进行交换，
    如果当前数字是一个奇数，那么直接跳过。

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        // 定义变量
        int bound = -1; 

        // 遍历nums
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & 1) == 0) {
                swap(nums, i, bound + 1);
                bound++;
            }
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
}