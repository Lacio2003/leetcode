/**
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        // The count stores the number of the uppercase letter.
        // The n stores the length of the word.
        int count = 0, n = word.length();
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) < 91 && count++ < i) {
                // Uppercase letters are not consecutive.
                return false;
            }
        }

        return count == n || count <= 1;
    }
}