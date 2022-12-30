/**
 * 思路：使用一个频数数组来存储nums排序之后的结果。从而可以降低时间复杂度。然后通过遍历频数数组，找到等于target的元素并记录位置。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // 使用一个频数数组来对数组进行排序
        int[] frequent = new int[101];

        // 记录target元素前面的元素的个数
        int preNumber = 0;
        // 将nums中的元素一次读入到频数数组当中
        for (int e : nums) {
            // 当前数字小于target，排序之后一定再target前面。记录元素个数
            if (e < target) {
                preNumber++;
            }
            // 频数数组的下标为nums中元素的值
            frequent[e]++;
        }

        // 存储答案的集合
        List<Integer> ans = new ArrayList<>();
        for (int i = preNumber; i < (preNumber + frequent[target]); i++) {
            // 将下标存入集合
            ans.add(i);
        }
        return ans;
    }
}