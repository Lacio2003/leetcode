/**
 * 思路：在一的基础上进行了优化。使用二分法查找进行优化
 * 时间复杂度：O(nlogn + logn)
 * 空间复杂度：O(1)
 */
class Solution {
    public int findFinalValue(int[] nums, int original) {
        // 对数组排序
        Arrays.sort(nums);

        // 使用二分查找进行查找，判断original是否在nums中存在
        while (Arrays.binarySearch(nums, original) >= 0) {
            original *= 2;
        }

        return original;
    }
}