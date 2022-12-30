/**
 * Use an in-place hash table.Place each number in its corresponding position.Then traversal to the nums for missing number.
 * Time complexity:O(n)
 * Space compelxity:(1)
 */
class Solution {
    public int missingNumber(int[] nums) {
        // For easy of use, the length of nums is stored in a variable.
        int len = nums.length;

        // Put each number in the right place.
        for (int i = 0; i < len; i++) {
            if (nums[i] != i && nums[i] < len) {
                // Use i-- until the number in each position can be equal to the subscript.
                swap(nums, nums[i], i--);
            }
        }

        // The ans stores the missing number.
        int ans = len;
        for (int i = 0; i < len; i++) {
            if (i != nums[i]) {
                // The current number is missing number.
                ans = i;
                break;
            }
        }

        return ans;
    }

    /**
     * Swap two position in the array.
     */
    private void swap(int[] nums, int first, int second) {
        nums[first] ^= nums[second];
        nums[second] ^= nums[first];
        nums[first] ^= nums[second];
    }
}