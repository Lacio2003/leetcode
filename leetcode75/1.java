/**
 * 本文使用快速排序的partition思想
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
class Solution {
    public void sortColors(int[] nums) {
        // 需要分解的数字
        int centerNum = 1;
        int n = nums.length;
        // l是比centerNum小的数字的左边界
        // r是比centerNum大的数字的有边界
        int l = -1, r = n;

        for (int i = 0; i < r;) {
            if (nums[i] < centerNum) {
                // 当前数字比centerNum小，将这个数字和l的下一个数字进行交换，
                // 并将左边界扩充
                swap(nums, ++l, i++);
            } else if (nums[i] > centerNum) {
                // 当前数字比centerNum大，将这个和r的前一个数字进行交换
                // 并将有边界扩充
                swap(nums, i, --r);
            } else {
                i++;
            }

        }
    }

    /**
     * 交换数组中的两个位置。
     */
    private void swap(int[] arr, int a, int b) {
        if (a != b) {
            arr[a] ^= arr[b];
            arr[b] ^= arr[a];
            arr[a] ^= arr[b];
        }
    }
}