/**
 * First, remove spaces at the end of the string.Second, calculating the length.
 * Time complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int lengthOfLastWord(String s) {
        // The length of the trailing string.
        int count = 0;
        // Iterate through the trailiing string, calculating the length.
        for (int i = trim(s); i >= 0 && s.charAt(i) != ' '; i--) {
            count++;
        }

        return count;
    }

    /**
     * Remove spaces at the end of the string.
     * @return The end of the string is not the position of the space.
     */
    private int trim(String s) {
        int index = s.length() - 1;
        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }

        return index;
    }
}