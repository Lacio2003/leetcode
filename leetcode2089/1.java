/**
 * 思路：按照题目要求对数组排序，然后遍历数组寻找符合要求的元素
 * 时间复杂度：O(nlogn + n)
 * 空间复杂度：O(1)
 */

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // 对数组进行非递减排序
        Arrays.sort(nums);

        // 因为事先不知道数组当中有几个符合target的元素
        List<Integer> list = new ArrayList<>();
        // 遍历数组，找到符合要求的下标
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }

        return list;
    }
}