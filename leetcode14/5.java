/**
 * Ideas:Because the longest common prefix string must no exceed the smallest length of string in the strs,you can find the smallest length first, and then use the dichotomy to continuously truncate the smallest length string.
 * For details, please see the official website solution.
 * Time complexity:O(mnlogm) n is the length of strs, m is the min length of string.
 * Space complexity:O(1)
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Get the min length of string in the strs.
        int minLen = minLen(strs);

        // Use binary lookup to find the longest common prefix.
        // Note the dichotomy to find boundary issue.
        int start = 0, end = minLen;
        while (start < end) {
            int mid = ((end - start + 1) >> 1) + start;
            if (isCommonPrefix(strs, mid)) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }

        return strs[0].substring(0, start);
    }

    /**
     * Get the min length of string in the strs.
     * @return The min length of string in the strs.
     */
    private int minLen(String[] strs) {
        int minLength = Integer.MAX_VALUE;
        for (String s : strs) {
            minLength = Math.min(s.length(), minLength);
        }

        return minLength;
    }

    /**
     * Determine whether the current string is a prefix for all strings in the strs.
     * @param len The length of the current string.
     * @return Return true if the current string is a prefix for all strings,otherwise return false.
     */
    private boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);

        for(String s : strs) {
            if (!s.startsWith(prefix)) {
                return false;
            }
        }

        return true;
    }
}