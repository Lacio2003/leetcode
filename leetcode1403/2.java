/**
 * 思路：使用贪心算法，对数组进行排序。先从最大值开始寻找。
 * 时间复杂度:O(nlogn)
 * 空间复杂度:O(logn)，排序需要栈空间为O(logn)
 */
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        // 计算nums的数组和
        int total = Arrays.stream(nums).sum();
        // 对数组进行排序
        Arrays.sort(nums);
        // 存储答案的集合
        List<Integer> ans = new ArrayList<>();

        // 当前数字和
        int curr = 0;
        // 根据贪心的算法，来寻找符合条件的序列
        for (int i = nums.length - 1; i >= 0; i--) {
            curr += nums[i];
            total -= nums[i];
            ans.add(nums[i]);
            if (curr > total) {
                break;
            }
        }

        return ans;
    }
}