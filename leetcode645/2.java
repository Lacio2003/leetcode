/**
 * Use a array to repersent to a hash table.The subscripts of the array repersent numbers from 1 to n.The elements of the nums is stored in the hash table.
 * The value in the hash table is 0, the current number is missing number, if the value is 2, the current number is a duplicated number.
 * Runtime complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    public int[] findErrorNums(int[] nums) {
        // For easy of use, the length of nums is stored in a variable.
        int n = nums.length;
        // The hash table.
        int[] cnt = new int[n + 1];
        for (int e : nums) {
            cnt[e]++;
        }

        // The ans stored the final answer.
        int[] ans = new int[2];
        for (int i = 1; i <= n; i++) {
            if (cnt[i] == 2) {
                // The duplicated number.
                ans[0] = i;
            }
            if (cnt[i] == 0) {
                // The missing number
                ans[1] = i;
            }
        }

        return ans;
    }
}