/**
 * First, we look for adjacent ascending elements from back to font.We assume that the first element in adjacent element ascending order has subscript of i and the second element is j.(All sequence following adjacent ascending elements must be non-incrementing sequences)
 * Second,We find the first number greater than i from j to nums.length - 1. (In this way,following elements must be in reverse order)
 * Finally, we reverse the element j to nums.length - 1.
 * website:https://leetcode.cn/problems/next-permutation/solutions/80560/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
 * Time complexity:O(n)
 * Space comlexity:O(1)
 */
class Solution {
    public void nextPermutation(int[] nums) {
        // Get the element that adjacent to the ascending order.
        int begin = findBorder(nums);
        if (begin != -1) {
            // If not compelete inverted, then swap.
            swap(nums, begin);
        }
        // Reverse the j to end elements.
        reverse(nums, begin + 1, nums.length - 1);
    }

    /**
     * Find the elements that adjacent to the ascending order.
     * @return The first subscript of an element in adjacent ascending order.
     */
    private int findBorder(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                return i;
            }
        }

        return -1;
    }

    /**
     * From j to end, find the first number greater than begin and swap it.
     * @param begin The first position in the adjacent ascending order.
     */
    private void swap(int[] nums, int begin) {
        for (int i = nums.length - 1; i > begin; i--) {
            if (nums[i] > nums[begin]) {
                nums[i] ^= nums[begin];
                nums[begin] ^= nums[i];
                nums[i] ^= nums[begin];
                break;
            }
        }
    }

    /**
     * Reverse the elements in the array.
     * @param begin Where to start
     * @param end Where to end
     */
    private void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            if (nums[begin] != nums[end]) {
                nums[begin] ^= nums[end];
                nums[end] ^= nums[begin];
                nums[begin] ^= nums[end];
            }
            begin++;
            end--;
        }
    }
}