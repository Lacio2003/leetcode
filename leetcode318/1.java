/**
 * Use binary to record the occurrence of each word character.
 * Time complexity:O(n^2)
 * Space complexity:O(n)
 */
class Solution {
    public int maxProduct(String[] words) {
        // The len stores the length of words.
        // The idx is index of the marks.
        int len = words.length, idx = 0;
        // Record the position of the character for each word.
        int[] marks = new int[len];

        // Record the position of the character for each word.
        for (String w : words) {
            int t = 0; 
            int curLen = w.length();
            // Get the position of the character for the current word.
            for (int i = 0; i < curLen; i++) {
                int c = w.charAt(i) - 'a';
                t |= (1 << c);
            }
            marks[idx++] = t;
        }

        // The max stores the final answer.
        int max = 0;
        for (int i = 0; i < len; i++) {
            int curLen1 = words[i].length();
            for (int j = i + 1; j < len; j++) {
                int curLen2 = words[j].length();
                int mul = curLen1 * curLen2;
                if ((marks[i] & marks[j]) == 0) {
                    // The characters of the current two words are not the same.
                    // Update the max.
                    max = Math.max(max, mul);
                }
            }
        }

        return max;
    }
}