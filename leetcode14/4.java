/**
 * Idea:Use the idea of partition.
 * Time complexity:O(mn), n is the number of strings, m is average length of the string in the array.
 * Space complexity:O(mlogn),n is the number of strings, m is average length of the string in the array.
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        return partition(strs, 0, strs.length - 1);
    }

    /**
     * Use the idea of partition to get the public prefix of the string.
     * @param str The strings array.
     * @return The common prefix between two strings.
     */
    private String partition(String[] strs, int begin, int end) {
        // Conditions for recursive ending.
        if (begin >= end) {
            return strs[begin];
        }

        int mid = ((end - begin) >> 1) + begin;
        String first = partition(strs, begin, mid);
        String second = partition(strs, mid + 1, end);

        return commonPrefix(first, second);
    }

    /**
     * Get the common prefix string between two strings.
     * @param s1 The first string.
     * @param s2 The second string.
     * @return The common prefix between two strings.
     */
    private String commonPrefix(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        int index = 0;
        while (index < len && s1.charAt(index) == s2.charAt(index)) {
            index++;
        }

        return s1.substring(0, index);
    }
}