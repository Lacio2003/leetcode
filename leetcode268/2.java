/**
 * First find the sum of 0 to n.Use this and subtract the elements in the array one by one, and the last remaining number is the missing number.
 * Time complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int missingNumber(int[] nums) {
        // First find the sum of 0 to n.
        int n = nums.length;
        int sum = n * (n + 1) / 2;

        // Use sum and subtract the element in the array one by one.
        for (int e : nums) {
            sum -= e;
        }

        return sum;
    }
}