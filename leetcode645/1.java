/**
 * Runtime complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        // The hash store the element of the nums.
        Set<Integer> hash = new HashSet<>();

        // The duplicate number.
        int dupNum = 0;
        for (int e : nums) {
            if (hash.contains(e)) {
                dupNum = e;
            }
            hash.add(e);
        }

        // The loss of number.
        int missNumber = 0;
        for (int i = 1; i <= nums.length; i++) {
            if (!hash.contains(i)) {
                missNumber = i;
            }
        }

        return new int[]{dupNum, missNumber};
    }
}