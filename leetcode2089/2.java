/**
 * 思路：使用一个频数数组来存储nums排序之后的结果。从而可以降低时间复杂度。然后通过遍历频数数组，找到等于target的元素并记录位置。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        // 使用一个频数数组来对数组进行排序
        int[] frequent = new int[101];

        // 将nums中的元素一次读入到频数数组当中
        for (int e : nums) {
            // 频数数组的下标为nums中元素的值
            frequent[e]++;
        }

        // 用来记录排序之后当前元素的位置
        int index = -1;
        // 存储最后的答案
        List<Integer> ans = new ArrayList<>();
        // 遍历frequent，记录target元素前面的元素的个数
        for (int i = 0; i <= target; i++) {
            // 找到target元素，将下标进行存储
            int form = index;
            while (i == target && index < (form + frequent[i])) {
                ans.add(++index);
            }
            // 记录位置的个数
            index += frequent[i];
        }

        return ans;
    }
}