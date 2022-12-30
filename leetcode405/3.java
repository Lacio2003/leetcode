/**
 * Use the bit operator to take out 4 bits each time and convert them.
 * Runtime complexity:O(8)
 * Space complexity:O(8)
 */
class Solution {
    public String toHex(int num) {
        // If the nums is zero, return "0" directly.
        if (num == 0) {
            return "0";
        }

        // The ans stores the final string.
        StringBuilder ans = new StringBuilder();
        while (num != 0) {
            // Take out 4 for binary.
            int cur = num & 15;
            // Convert cur to the character number.
            char c = (char)(cur + '0');
            if (cur > 9) {
                // If the cur is greater than 9.
                // Convert the cur to the hexadecimal character.
                c = (char)(cur - 10 + 'a');
            }
            ans.append(c);
            num >>>= 4;
        }

        return ans.reverse().toString();
    }
}