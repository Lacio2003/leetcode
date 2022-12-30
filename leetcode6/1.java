/**
 * Idea:According to the z-shaped, the letters is stored on the corresponding line.Then, return directly.
 * Time complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    public String convert(String s, int numRows) {
        // When numsRows == 1, return directly.
        if (numRows == 1) {
            return s;
        }
        // Store the characters of each line in the z-shaped.
        List<StringBuilder> storge = new LinkedList<>();
        // Intialize the storge.
        for (int i = 0; i < numRows; i++) {
            storge.add(new StringBuilder());
        }

        // For easy of traversal,The length of s is storged in a varaible.
        int n = s.length();
        // line stands for line.
        // flag is used for line increments.
        int line = 0, flag = -1;
        // Store the letters on the corresponding line.
        for (int i = 0; i < n; i++) {
            storge.get(line).append(s.charAt(i));
            // According to the z-shaped.
            if (line == 0 || line == numRows - 1) {
                flag = -flag;
            }
            line += flag;
        }

        // Take out the results.
        StringBuilder ans = new StringBuilder();
        for (StringBuilder e : storge) {
            ans.append(e.toString());
        }

        return ans.toString();
    }
}