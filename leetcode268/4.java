/**
 * Use hash table stores the numbers of nums.Then traversal the hash table for missing number.
 * Time complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    public int missingNumber(int[] nums) {
        // For easy of use, the length of nums is stored in a variable.
        int len = nums.length;
        // The hash table stores the numbers of the nums.
        boolean[] hash = new boolean[len + 1];
        for (int e : nums) {
            // The current is not missing number.
            hash[e] = true;
        }

        // The ans stores the missing number.
        int ans = 0;
        for (int i = 1; i <= len; i++) {
            if (!hash[i]) {
                // The current number is missing number.
                ans = i;
                break;
            }
        }

        return ans;
    }
}