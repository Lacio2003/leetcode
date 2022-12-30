/**
 * Use the two-pointer idea.
 * Time complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    // The hahs stores the vowels.
    private static Set<Character> hash = new HashSet<>(){{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
    }};
    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        // Use the two-pointer.
        for (int l = 0, r = len - 1; l < r;) {
            char leftChar = Character.toLowerCase(arr[l]), rightChar = Character.toLowerCase(arr[r]);
            if (hash.contains(leftChar) && hash.contains(rightChar)) {
                // Both characters are vowel characters.
                swap(arr, l++, r--);
            } else {
                // Move the two pointers.
                l += !hash.contains(leftChar) ? 1 : 0;
                r -= !hash.contains(rightChar) ? 1 : 0;
            }
        }

        return new String(arr);
    }

    /**
     * Swap the position of two character in the character array.
     */
    private void swap(char[] arr, int a, int b) {
        if (arr[a] != arr[b]) {
            char c = arr[a];
            arr[a] = arr[b];
            arr[b] = c;
        }
    }
}