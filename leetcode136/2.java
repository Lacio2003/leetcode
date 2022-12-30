/**
 * Use the hash table to store the each number and their occurrences.
 * Then find the number with an occurrences of 1.
 * Time complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    public int singleNumber(int[] nums) {
        // The map stores the each number and their corresponding number of occurrences.
        Map<Integer, Integer> map = new HashMap<>();
        for (int e : nums) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }

        // The ans stores the final answer.
        int ans = 0;
        for (int e : nums) {
            if (map.get(e) == 1) {
                // The current number appears once.
                ans = e;
            }
        }

        return ans;
    }
}