class Solution {
    public int smallestRangeI(int[] nums, int k) {
        // 获取最大值
        int max = Arrays.stream(nums).max().getAsInt();
        // 获取最小值
        int min = Arrays.stream(nums).min().getAsInt();

        // 返回结果
        return max - min <= 2 * k ? 0 : max - min - 2 * k;
    }
}