/**
 * Use a hash table to exclude duplicate numbers.
 * Time complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        // The hash table stores numbers and check the duplicate numbers.
        Set<Integer> hash = new HashSet<>();

        for (int e : nums) {
            if (hash.contains(e)) {
                // The current appears twice in the array.
                hash.remove(e);
                continue;
            }
            hash.add(e);
        }

        // Read the data in the set to the array.
        int[] ans = new int[2];
        int index = 0;
        for (int e : hash) {
            ans[index++] = e;
        }

        return ans;
    }
}