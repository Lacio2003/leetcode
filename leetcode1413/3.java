/**
 * 思路：使用二分法查找的方法。因为符合条件的startValue一定具有单调性。即：比startValue大的数字一定
 * 满足累加和大于0，比startValue小的数字一定不满足累加和大于0.
 * 时间复杂度：O(nxlog(n))
 * 空间复杂度：O(1)
 */
class Solution {
    public int minStartValue(int[] nums) {
        int left = 1, right = -getRight(nums) + 1;
        while (left <= right) {
            int mid = (right + left) >> 1;
            if (check(nums, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right == 0 ? 1 : right;
    }

    /**
     * 获得右边界(右边界等于数组中所有负数的和)
     * @param nums nums数组
     * @return 右边界
     */
    private int getRight(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num < 0 ? num : 0;
        }

        return sum;
    }
    /**
     * 检查当前数字是否满足题目要求
     * @param nums nums数组
     * @param startValue 开始的数字
     * @return 如果累加和有负值，返回true。否则返回false
     */
    private boolean check(int[] nums, int startValue) {
        for (int num : nums) {
            startValue += num;
            if (startValue <= 1) {
                return true;
            }
        }

        return false;
    }
}