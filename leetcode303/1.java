/**
 * 思路：直接按照题目求解。使用一个数组存储原来数组中的元素。求和的时候直接使用
 * 循环来求和。
 * 时间复杂度:m * O(n) m为方法的调用次数
 * 空间复杂度:O(n)
 */
class NumArray {
    // 存储数组中的元素
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        // 使用下标遍历指定的位置求和
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += nums[i];
        }

        return sum;
    }
}
