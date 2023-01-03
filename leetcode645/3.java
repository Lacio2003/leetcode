/**
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        // For eays of use, the length of nums is stored in a variable.
        int n = nums.length;
        // The hash table.
        int[] cnt = new int[n + 1];
        // The total represents the sum of 1 to n.
        // The sum represents the sum of nums.
        // The sum represents the sum of distinct elements in the array.
        int total = n * (n + 1) >> 1, sum = 0, dupSum = 0;
        for (int e : nums) {
            sum += e;
            if (cnt[e] == 0) {
                dupSum += e;
            }
            cnt[e] = 1;
        }

        return new int[]{sum - dupSum, total - dupSum};
    }
}