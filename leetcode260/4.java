/**
 * You can first distinguish between two numbers.Then use ^ operator to take it out.
 * Time complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int e : nums) {
            xor ^= e;
        }

        // The ans stores the final answer.
        int[] ans = new int[2];
        // The mask stores two numbers in a different position on the far right of the binary side.
        /*
          Integer.MIN_VALUE = 10000000 00000000 00000000 00000000
          Intger.MIN_VALUE & -Integer.MIN_VALUE = 
            10000000 00000000 00000000 0000000 & 10000000 00000000 00000000 0000000 = 10000000 00000000 00000000 0000000
         */
        int mask = (Integer.MIN_VALUE == xor) ? xor : xor & (-xor);
        for (int num : nums) {
            if ((num & mask) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }

        return ans;
    }
}