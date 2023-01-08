/**
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        // The line storeds the total number of lines.
        // The cur stores the widthe of the last line in pixels.
        int line = 1, cur = 0;
        for (char c : s.toCharArray()) {
            // Get the number of pixels the current character.
            int num = widths[c - 'a'];
            if (num + cur > 100) {
                // Line break.
                line++;
                cur = num;
            } else {
                cur += num;
            }
        }

        return new int[]{line, cur};
    }
}