/**
 * Runtime complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        // Determines whether you are dealing with characters or one character.
        boolean flag = true;
        int i = 0;
        while (i < bits.length - 1) {
            String cur = bits[i] + "" + bits[i + 1];
            if ("10".equals(cur) || "11".equals(cur)) {
                // Deal with two characters.
                flag = false;
                i += 2;
            } else {
                // Deal with one character.
                flag = true;
                i++;
            }
        }

        return i == bits.length - 1 || flag;
    }
}