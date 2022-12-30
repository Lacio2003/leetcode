/**
 * Idea:Spread from a string to both sides.Thus, Get the length of a palindromic 
 * substring.The compare to find the longest length of the palindromic substring.
 * Time complexity:O(N^2)
 * Space complexity:O(1)
 */
class Solution {
    public String longestPalindrome(String s) {
        // For ease of use, the length of s is stored in len.
        int len = s.length();
        // Return directly when the len is less than 2.
        if (len < 2) {
            return s;
        }

        // The max length of the palindromic substring.
        int maxLength = 0;
        // The start position and length of the longest palindromic substring.
        int[] ans = new int[2];
        for (int i = 0; i < len - 1; i++) {
            // When the palindromic substring is odd.
            int[] odd = centerSpread(s, i, i); 
            // When the palindromic sbustring is even.
            int[] even = centerSpread(s, i, i + 1); 
            // Get the largest of them.
            int[] max = odd[1] > even[1] ? odd : even;

            // Update the maxLength.
            if (max[1] > maxLength) {
                ans[0] = max[0];
                ans[1] = max[1];
                maxLength = max[1]; 
            }
        }

        return s.substring(ans[0], ans[0] + ans[1]);
    }

    /**
     * Spread from the center of a string to both sides.Thus, Get the length of the palindromic substring.
     * @param left The left position of the start.
     * @param right The right position of the start.
     * @param s The string s.
     * @return The start and end positions of the palindromic substring.
     */
    private int[] centerSpread(String s, int left, int right) {
        int len = s.length();
        while (left >= 0 && right < len) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }

        return new int[]{left + 1, right - left - 1};
    }
}