/**
 * Categorize arrording to the tropic.
 * Runtime complexity:O(3 * n)
 * Sapce complexity:O(1)
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        char[] arr = word.toCharArray();
        if (AllCaptials(arr) || AllNotCaptials(arr) || FirstCaptials(arr)) {
            return true;
        }

        return false;
    }

    /**
     * All letters in this word are capitals.
     */
    private boolean AllCaptials(char[] arr) {
        for (char e : arr) {
            if (Character.isLowerCase(e)) {
                return false;
            }
        }

        return true;
    }

    /**
     * All letters in this word are not capitals.
     */
    private boolean AllNotCaptials(char[] arr) {
        for (char e : arr) {
            if (Character.isUpperCase(e)) {
                return false;
            }
        }

        return true;
    }

    /**
     * only the first letter in this word is capital.
     */
    private boolean FirstCaptials(char[] arr) {
        if (Character.isLowerCase(arr[0])) {
            return false;
        }

        for (int i = 1; i < arr.length; i++) {
            if (Character.isUpperCase(arr[i])) {
                return false;
            }
        }

        return true;
    }
}