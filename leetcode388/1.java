/**
 * Gets the string for each level.The get the length.
 * website:https://leetcode.cn/problems/longest-absolute-file-path/solutions/1434968/by-ac_oier-c55t/
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int lengthLongestPath(String input) {
        // The map stores the length of each level string.
        Map<Integer, Integer> map = new HashMap<>();
        // The length of the input.
        int len = input.length();
        // The max length.
        int max = 0;
        for (int i = 0; i < len;) {
            // Get the level at which the current string is located.
            int level = 0;
            while (i < len && input.charAt(i) == '\t') {
                // A '\t' resprents one layer.
                level++;
                i++;
            }

            // The isDir is used to determine whether it is a folder or not.
            boolean isDir = true;
            int j = i;
            // Get the string for this layer.
            while (j < len && input.charAt(j) != '\n') {
                if (input.charAt(j) == '.') {
                    isDir = false;
                }
                j++;
            }

            // The length of the current string.
            int cur = j - i;
            // The length of the previous string.
            int prev = map.getOrDefault(level - 1, 0);
            // Get the sum of cur and prev.
            int curLength = prev == 0 ? cur : prev + 1 + cur; 
            if (isDir) {
                // The current string is a folder.
                map.put(level, curLength);
            } else {
                // The current string a file.
                max = Math.max(max, curLength);
            } 
            i = j + 1;
        }

        return max;
    }
}