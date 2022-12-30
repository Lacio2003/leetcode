/**
 * 暴力破解：根据题意可得，我们先从数组当中的最大值找起。
 * 1)先对数组进行排序。
 * 2)制造前缀和数组(因为需要和其他数字的和做比较)
 * 3)遍历数组找出符合条件的序列
 * 时间复杂度：O(nlogn + n + n)
 * 空间复杂度：O(n), 不算返回结果的集合。
 */
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        // 对nums进行排序，目的是方便从最大值找起
        Arrays.sort(nums);

        // 后面会多次用到，使用一个变量存储nums的长度
        int n = nums.length;
        
        // 制造前缀和数组
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        // 存储答案的集合
        List<Integer> ans = new ArrayList<>();

        // 序列和
        int sum = 0;
        // 从最大值找起，找出符合条件的序列
        for (int i = n - 1; i >= 0 && sum <= prefixSum[i + 1]; i--) {
            ans.add(nums[i]);
            sum += nums[i];
        }

        return ans;
    }
}