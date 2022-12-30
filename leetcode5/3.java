/**
 * Idea:Use the idea of dynamic programming.Use the dp array to record whether a string is a palindromic substring.This reduces the time complexity.
 * Time complexity:O(N^2)
 * Space complexity:O(N^2);
 */
class Solution {
    public String longestPalindrome(String s) {
        // For ease of use, store the length of s in the variable.
        int n = s.length();
        // If the string length is less than 2, it can be returned directly.
        if (n < 2) {
            return s;
        }

        // An array that holds the state of the s.
        boolean[][] dp = new boolean[n][n];
        // Initialize dp.
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        
        // For ease traversal, turn s into a char array.
        char[] array = s.toCharArray();

        // The max length of the palindromic substring.
        int maxLength = 1;
        // Where the palindromic sbustring begins.
        int begin = 0; 

        // Traversal the array for the palindromic substring.
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                // Use the dp arary to see if the current string is palindromic substring.
                dp[i][j] = (array[i] == array[j]) && (j - i < 3 || dp[i + 1][j - 1]);
                // If it is a palindromic substring and the length if larger than maxLength, update.
                if (dp[i][j] && maxLength < (j - i + 1)) {
                    maxLength = j - i + 1;
                    begin = i;
                }
            }
        }

        // Return the max length of a palindromic substring.
        return s.substring(begin, begin + maxLength);
    }
}