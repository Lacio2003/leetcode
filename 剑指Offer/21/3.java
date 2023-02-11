/*
    准备两个指针i和j，一个指向开头，用来寻找奇数，一个指向末尾，用来寻找偶数。
    如果i遇到偶数,j遇到奇数，那么就交换，直到两个指针重合。

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int[] exchange(int[] nums) {
        // 准备两个指针
        int left = 0, right = nums.length - 1;
        // 遍历
        while (left < right) {
            // 左指针找到偶数
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }
            while (right > left && (nums[right] & 1) == 0) {
                right--;
            }

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
        }

        return nums;
    }
}