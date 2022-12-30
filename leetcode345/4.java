/**
 * Improvement the basic of 2.java.An array is used instead of a hash table.
 * Time complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    // The hash table stores the character.
    static boolean[] hash = new boolean[128];
    // The character array of vowels.
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    static {
        // Initialize the hash table.
        for (char vowel: vowels) {
            hash[vowel - ' '] = hash[Character.toUpperCase(vowel) - ' '] = true;
        }
    }
    public String reverseVowels(String s) {
        // For easy of use, Convert the strings to the character array.
        char[] arr = s.toCharArray();
        // For easy of use, the length of s is stored in a variable.
        int len = s.length();
        // Use two-pointer.
        for (int l = 0, r = len - 1; l < r;) {
            int left = arr[l] - ' ', right = arr[r] - ' ';
            if (hash[left] && hash[right]) {
                // Both characters is vowels.
                swap(arr, l++, r--);
            } else {
                // Move the pointer.
                l += !hash[left] ? 1 : 0;
                r -= !hash[right] ? 1 : 0;
            }
        }

        return String.valueOf(arr);
    }

    /**
     * Swap the two character in the character array. 
     */
    private void swap(char[] arr, int a, int b) {
        if (arr[a] != arr[b]) {
            char c = arr[a];
            arr[a] = arr[b];
            arr[b] = c;
        }
    }
}