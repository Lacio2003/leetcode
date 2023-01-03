/**
 * website:https://leetcode.cn/problems/set-mismatch/solutions/857445/gong-shui-san-xie-yi-ti-san-jie-ji-shu-s-vnr9/
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        // For easy of use, the length of nums is stored in a variable.
        int n = nums.length;
        // Put every number in the right place.
        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }

        // The dupNum represents the duplicated number.
        // The misNum represents the duplicated number.
        int dupNum = -1, missNum = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                dupNum = nums[i];
                missNum = i == 0 ? 1 : i + 1;
            }
        }

        return new int[]{dupNum, missNum};
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }
}