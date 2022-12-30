/**
 * Ideas:Sort the strs first.The look for the common prefix string in the first string and the last string.
 * Time complexity:O(nlogn + m).Suppose the time of sroting the strs is O(nlogn).m is the time of look for a common prefix.
 * Space complexity:O(1)
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Sort the strs first.
        Arrays.sort(strs);

        // Look for the longest common prefix string in thr first string and the last string.
        String first = strs[0], last = strs[strs.length - 1];
        int length = Math.min(first.length(), last.length());
        int index = 0;
        while (index < length && first.charAt(index) == last.charAt(index)) {
            index++;
        }
        // Return the longest common prefix string.
        return first.substring(0, index);
    }
}