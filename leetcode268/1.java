/**
 * Use hash table store the elements of nums.Travere from 0 to n to check if it has appeared in the hash table.
 * Time complexity:O(n);
 * Space complexity:O(n);
 */
class Solution {
    public int missingNumber(int[] nums) {
        // The hash stores the elements of nums.
        Set<Integer> hash = new HashSet<>();
        for (int e : nums) {
            hash.add(e);
        }

        // The ans store the missing number.
        int ans = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (!hash.contains(i)) {
                // The current number is missing number.
                ans = i;
                break;
            }
        }

        return ans;
    }
}