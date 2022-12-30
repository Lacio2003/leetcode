/**
 * Idea:Improvement on the basic of 1.
 * Time complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    public String convert(String s, int numRows) {
        // When the numRows is equals to 1, the program return s directly.
        if (numRows == 1) {
            return s;
        }

        // Store the corresponding character for each line.
        List<StringBuilder> store = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            store.add(new StringBuilder());
        }

        // One cycle.
        int n = 2 * numRows - 2;
        // For easy for use, the length of s is stored to variable len.
        int len = s.length();
        // Store characters to the corresponding line.
        for (int i = 0; i < len; i++) {
            int x = i % n;
            store.get(Math.min(x, n - x)).append(s.charAt(i));
        }

        // Stitch strings of different lines together.
        StringBuilder ans = new StringBuilder();
        for (StringBuilder e : store) {
            ans.append(e.toString());
        }
        return ans.toString();
    }
}