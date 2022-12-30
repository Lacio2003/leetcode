/**
 * 思路：利用二分法对寻找过程中进行优化。
 * 步骤：
 *  1.遍历数组，确定i的位置
 *  2.在i确定的基础上，利用二分法寻找j的位置
 *  3.在j确定的基础上，使用二分法寻找k的位置
 *  4.如果i，j，k都可以找到则将三元组的数组加一。
 */

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        // 记录三元组的数组
        int count = 0;
        // 确定i的位置
        for (int i = 0; i < nums.length; i++) {
            // 确定j的位置
            int j = binarySearch(nums, i + 1, nums.length - 1, diff + nums[i]);
            // 确定k的位置
            if (j != -1) {
                // 确定K的位置
                int k = binarySearch(nums, j + 1, nums.length - 1, diff + nums[j]);
                if (k != -1) {
                    // 找到一个三元组
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 使用二分法在指定数组中寻找指定的键值
     * @param nums 要寻找的键值的数组
     * @param left 寻找的位置的左边界
     * @param right 寻找的位置的右边界
     * @param target 要寻找的键值
     * @return int 寻找键值的下标，如果不存在返回-1
     */
    private int binarySearch(int[] nums, int left, int right, int target) {
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}