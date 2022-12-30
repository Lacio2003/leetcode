/**
 * Idea:The sitpulation that the step is According to the title, you can get:
 *   0 and numRows - 1 ' spacing is step. 
 *   The other spacing is step - 2 * i and 2 * i alternately.
 * Time complexity:O(n);
 * Space complexity:O(1);
 */
class Solution {
    public String convert(String s, int numRows) {
        // When the numRows is equal to 1, the program return s directly.
        if (numRows == 1) {
            return s;
        }

        // The ans is used to store the ans's string.
        StringBuilder ans = new StringBuilder();

        // For easy for use, the length of s is storged in variable len.
        int len = s.length();
        // According to the obtained rules,the string is traversed.
        // Add the corresponding characters to the corresponding line.
        for (int i = 0; i < numRows; i++) {
            int step = 2 * numRows - 2, add = 2 * i;
            int index = i;
            while (index < len) {
                ans.append(s.charAt(index));
                add = step - add;
                // 0 and numsRows - 1 ' spacing is step.
                // The other spacing is (2 * i) and (step - 2 * i) alternately;
                index += (i == 0 || i == numRows - 1) ? step : add;
            }
        }

        // Return the ans.
        return ans.toString();
    }
}