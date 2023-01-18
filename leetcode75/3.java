/**
 * website:https://leetcode.cn/problems/sort-colors/solutions/437968/yan-se-fen-lei-by-leetcode-solution/
 * 使用两个指针，ptr0是0的边界，ptr1是1的边界。
 * 当前数字是1，直接和ptr1的下一个数字进行交换。
 * 当前数字是0，和ptr0的下一个数字进行交换。但是，因为ptr1在ptr0之后，所以，可能会将
 * 1交换出去。所以，为了防止这种情况的发生，需要在和ptr1进行一次交换。
 * 这样0和1都拍序好之后，最后的元素一定是2了。
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
class Solution {
    public void sortColors(int[] nums) {
        // ptr0是0的边界,ptr1是1的边界。
        int ptr0 = -1, ptr1 = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                swap(nums, i, ptr1 + 1);
                ptr1++;
            } else if (nums[i] == 0) {
                swap(nums, i, ptr0 + 1);
                if (ptr0 < ptr1) {
                    swap(nums, i, ptr1 + 1);
                }
                ptr0++;
                ptr1++;
            }
        }
    }

    /**
     * 交换数组中两个位置的数字
     */
    private void swap(int[] nums, int a, int b) {
        if (a != b) {
            nums[a] ^= nums[b];
            nums[b] ^= nums[a];
            nums[a] ^= nums[b];
        }
    }
}