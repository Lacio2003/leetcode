/**
 * Idea:When the large character is in front of the small character,the addition operation is performed, and when the small character is in front of the large character,the substraction is performed.
 * Time complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int romanToInt(String s) {
        // For easy for use, Converts the String s to the char array.
        char[] array = s.toCharArray();
        // The ans stores the final numbers.
        int ans = 0;
        for (int i = 0; i < array.length; i++) {
            int cur = convertNum(array[i]);
            if (i < array.length - 1 && cur < convertNum(array[i + 1])) {
                // Small character are in font of large characters, and the operation is subtracted.
                cur = -cur;
            }
            // Add the current number.
            ans += cur;
        }

        return ans;
    }

    /**
     * Converts Roman characters to the corresponding numbers.
     * @param c The Roman character.
     * @return The number corresponding to the Roman character.
     */
    private int convertNum(char c) {
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
        }

        return 1000;
    }
}