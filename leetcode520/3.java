/**
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.toUpperCase().equals(word)) {
            return true;
        } else if (word.toLowerCase().equals(word)) {
            return true;
        } else if (Character.isUpperCase(word.charAt(0))) {
            int n = word.length();
            for (int i = 1; i < n; i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
            return true;
        }

        return false;
    }
}