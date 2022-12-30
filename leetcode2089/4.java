/**
 * 思路：在上一次的基础上进行优化，直接使用两个变量进行存储。进一步降低了空间复杂度
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // preNumbers为排序之后，target左边的元素的个数，targetNumber为target元素的个数
        int preNumbers = 0, targetNumbers = 0;
        for (int e : nums) {
            // 记录小于target元素的数目
            if (e < target) {
                preNumbers++;
            }
            // 记录等于target元素的数目
            if (e == target) {
                targetNumbers++;
            }
        }

        // 存储最后答案的集合
        List<Integer> ans = new ArrayList<>();
        // 答案区间为[preNumber, perNumbers + targetNumbers)
        for (int i = preNumbers; i < preNumbers + targetNumbers; i++) {
            ans.add(i);
        }

        return ans;
    }
}