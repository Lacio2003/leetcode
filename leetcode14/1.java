/**
 * Idea:Brute force cracking.Use each character of the first string match the following strings once.
 * Time complexity:O(m*n) m is the length of the first string, n is the length of the strs.
 * Space complexity:O(1)
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // The length of the first string.
        int firstLen = strs[0].length();
        // Traversal the strs,look for the longest common public prefix. 
        for (int i = 0; i < firstLen; i++) {
            // Determines whether thr current character is a common prefix.
            char cur = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || cur != strs[j].charAt(i)) {
                    // If the current character is not a common prefix, return the previous public prefix.
                    return strs[0].substring(0, i);
                }
            }
        }

        // If the program can execute here, then the longest common prefix string is the first string.
        return strs[0];
    }
}