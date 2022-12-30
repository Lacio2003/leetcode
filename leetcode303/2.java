/**
 * 思路：使用前缀和数组。来来存储前缀和，从而可以将求和的时间降到O(1)
 * 时间复杂度：O(m), m为调用sumRange()的次数
 * 空间复杂度：O(n)
 */
class NumArray {
    // 存储前缀和的数组
    int[] prefixSum;
    public NumArray(int[] nums) {
        // 对前缀和数组进行初始化
        prefixSum = new int[nums.length + 1];
        // 对前缀和数组填充数据
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        // 利用前缀和数组进行返回
        return prefixSum[right + 1] - prefixSum[left];
    }
}
