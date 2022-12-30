/**
 * Idea:Iterate through each substring of s with length greater than 2 or equal 2 and Determine whether it is a palindromic substring.Find the largest and return it.
 * Time complexity:O(n^3)
 * Space complexity:O(1);
 */
class Solution {
    public String longestPalindrome(String s) {
        // For ease of use, store the length of s in a variable.
        int n = s.length();
        // The length is less than 2 and there is only one character.
        if (n < 2)  {
            return s;
        }

        // Turn strings into character array for easy traversal.
        char[] array = s.toCharArray();
        // The max length of palindromic substring.
        int maxLength = 1;
        // Where paildromic strings begin and end.
        int begin = 0, end = 0;

        // Traversal to find palindromci substring.
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // If a palindromic substring is found and the length if larger
                // than maxLength, and update it.
                if (maxLength < (j - i + 1) && validPalinString(array, i, j)) {
                    maxLength = j - i + 1;
                    begin = i;
                    end = j;
                }
            }
        }

        // Return the max length of palindromic substring.
        return s.substring(begin, end + 1);
    }

    /**
     * Determine whether a string is palindromic string.
     * @param begin Where the string begins.
     * @param end Wherer the string ends.
     * @return Return true if a string is a palindromic substring, otherwise return false.
     */
    public boolean validPalinString(char[] array, int begin, int end) {
        while (begin < end) {
            if (array[begin] != array[end]) {
                return false;
            }

            begin++;
            end--;
        }

        return true;
    }
}