/**
 * Count the number of the uppercase letter, then judge by according the the number of uppercase letter.
 * Runtim complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public boolean detectCapitalUse(String word) {
        // For easy of use, convert the word to the char array.
        char[] arr = word.toCharArray();
        // Couont the number of the uppercase letters.
        int countCapital = 0;

        for (int i = 0; i < arr.length; i++) {
            if (Character.isUpperCase(arr[i])) {
                countCapital++;
            }
        }

        return countCapital == 0 || countCapital == arr.length || (countCapital == 1 && Character.isUpperCase(arr[0]));
    }
}