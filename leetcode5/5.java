/**
 * Ideas: Use the Manacher to find the longest palindromic substring in the string.
 * Time complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    public String longestPalindrome(String s) {
        if (null == s || s.length() == 0) {
            return s;
        }
        // Preprocess the string.
        String processed = preprocess(s);
        // Use Manacher to find the longest palindromic substring int the processed.
        String palindromicString = findPalindromic(processed);
        // Remove the special substring in the palindromicString.
        return removeSpecialChar(palindromicString);

    }

    /**
     * Preprocess the string.Add # to the string beginning and trail and spacing.
     *
     * @param string The string that needs to process.
     * @return The string after processing.
     */
    private static String preprocess(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            stringBuilder.append("#");
            stringBuilder.append(string.charAt(i));
        }

        stringBuilder.append("#");
        return stringBuilder.toString();
    }

    /**
     * Use Manacher to find the longest palindromic substring in a string.
     * @param string A string.
     * @return The longest palindromic substring in a string.
     */
    private static String findPalindromic(String string) {
        // For easy to traversal, the string is converted to a char array.
        char[] array = string.toCharArray();
        // For easy to use, The length of string is stored in a variable.
        int n = array.length;
        // The array of palindromic radius.
        int[] radius = new int[n];
        // c is the center of the rightest palindromic substring.
        // r is the right bound of the rightest palindromic substring.
        int c = -1, r = -1;
        // max is the center of the longest palindromic substring.
        int max = 0;
        for (int i = 0; i < n; i++) {
            // Treatment of both cases of Manacher.
            radius[i] = r > i ? Math.min(radius[2 * c - i], r - i) : 1;
            // Diffusion from the midpoint.
            while ((i - radius[i] > -1) && (i + radius[i] < n) && (array[i + radius[i]] == array[i - radius[i]])) {
                radius[i]++;
            }

            // Update the c and r.
            if (i + radius[i] > r) {
                r = i + radius[i];
                c = i;
            }
            // Update the max
            if (radius[i] > radius[max]) {
                max = i;
            }
        }

        // Return the longest palindromic substring.
        return string.substring(max - radius[max] + 1, max + radius[max]);
    }

    /**
     * Remove the special string from the palindromic substring.
     * @param string The palindromic substring with the special substring.
     * @return The palindromic substring without the special substring.
     */
    private static String removeSpecialChar(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = string.length() - 1; i > -1; i--) {
            // Remove the "#".
            if (string.charAt(i) != '#') {
                stringBuilder.append(string.charAt(i));
            }
        }

        return stringBuilder.toString();
    }

}