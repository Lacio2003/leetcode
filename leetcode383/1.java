/**
 * Use hash table to store the character frequency of magazine.
 * Time complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // The hash table stores the character frequency of magazine.
        int[] hash = new int[26];
        for (int i = magazine.length() - 1; i >= 0; i--) {
            hash[magazine.charAt(i) - 'a']++;
        }

        for (int i = ransomNote.length() - 1; i > -1; i--) {
            int position = ransomNote.charAt(i) - 'a';
            if (hash[position] <= 0) {
                // The magazine does not exit for the current number.
                return false;
            }
            hash[position]--;
        }

        return true;
    }
}