/**
 * 思路：按照题目要求，进行解答即可。
 * 时间复杂度：O(n^2)，每次需要遍历整个数组
 * 空间复杂度：O(1);
 */
class Solution {
    public int findFinalValue(int[] nums, int original) {
        // 按照题目要求进行循环即可
        while (search(nums, original)) {
            original *= 2;
        }
        return original;
    }
    /**
     * 检查数组中是否存在某一个值
     * @param nums 需要检查的数组
     * @param key 检查的关键字
     * @return 是否存在
     */
    private boolean search(int[] nums, int key) {
        int i = 0;
        while (i < nums.length && nums[i] != key) {
            i++;
        }
        return i < nums.length;
    }
}