/**
 * Runtime complexity:O(n^3)
 * Space complexity:O(C) C is 26;
 */
class Solution {
    // The frequent array of the licensePlate.
    int[] licenFre = new int[26];
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // Get the frequent of the licensePlate.
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                licenFre[Character.toLowerCase(c) - 'a']++;
            }
        }

        // The maxLen stores the largest length of string.
        int maxLen = -1;
        for (int i = 0; i < words.length; i++) {
            if (check(words[i]) && (maxLen == -1 || words[i].length() < words[maxLen].length())) {
                maxLen = i;
            }
        }

        return words[maxLen];
    }

    /**
     * Check the current string whether is eligible.
     */
    private boolean check(String s) {
        for (int i = 0; i < 26; i++) {
            if (licenFre[i] > 0 && (count(s, (char)(i + 'a')) < licenFre[i])) {
                return false;
            }
        }

        return true;
    }

    /**
     * Get the number of time c appears in s.
     */
    private int count(String s, char c) {
        int count = 0;
        for (char e : s.toCharArray()) {
            if (e == c) {
                count++;
            }
        }

        return count;
    }
}