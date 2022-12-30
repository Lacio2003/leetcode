/**
 * Idea:Iterate through each substring of s with length greater than 2 or equal 2 and Determine whether it is a palindromic substring.Find the largest and return it.Use a recursive implementation.
 * Time complexity:O(n^3)
 * Space complexity:O(2^n);
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
        recursive(array, 0, 1);

        return s.substring(begin, end + 1);
    }

    // The max length of palindromic substring.
    int maxLength = 1;
    // Where the palindromic substring begins and ends.
    int begin = 0, end = 0;
    private void recursive(char[] array, int i, int j) {
        // The end condition of recursive.
        if (i >= array.length - 1) {
            return;
        }

        // If The length of a palindromic is larger than the maxLength, update.
        if (maxLength < (j - i + 1) && validPalinString(array, i, j)) {
            maxLength = j - i + 1;
            this.begin = i;
            this.end = j;
        }

        // Update subscripts.
        if (j >= array.length - 1) {
            i++;
            j = i;
        }
        // Continue recursive.
        recursive(array, i, j + 1);
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