/**
 * Runtime complexity:O(n) n is the sum of length of string in the words.
 * Space complexity:O(n)
 */
class Solution {
    // The full table for 26 letters of the english alphabet.
    static String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        // The hash table stores the morse code.
        Set<String> hashSet = new HashSet<>();

        // Convert the word to the morse code.
        for (int i = 0; i < words.length; i++) {
            hashSet.add(transformat(words[i]));
        }

        return hashSet.size();
    }

    /**
     * Convert the s to the morse code.
     */
    private String transformat(String s) {
        StringBuilder ans = new StringBuilder();
        for (char c : s.toCharArray()) {
            // Get the morse code of the current character.
            ans.append(morseCode[c - 'a']);
        }

        return ans.toString();
    }
}