/**
 * Calculations are performed using decimal rules.
 * Time complexity:O(log26)
 * Space complexity:O(log26)
 */
class Solution {
    Map<Integer, String> map = new HashMap<>(){{
        put(1, "A");
        put(2, "B");
        put(3, "C");
        put(4, "D");
        put(5, "E");
        put(6, "F");
        put(7, "G");
        put(8, "H");
        put(9, "I");
        put(10, "J");
        put(11, "K");
        put(12, "L");
        put(13, "M");
        put(14, "N");
        put(15, "O");
        put(16, "P");
        put(17, "Q");
        put(18, "R");
        put(19, "S");
        put(20, "T");
        put(21, "U");
        put(22, "V");
        put(23, "W");
        put(24, "X");
        put(25, "Y");
        put(0, "Z");
    }};
    public String convertToTitle(int columnNumber) {
        // The ans stores the final answer.
        StringBuilder ans = new StringBuilder();
        while (columnNumber > 0) {
            // Get the final answer.
            String cur = map.get(columnNumber % 26);
            ans.append(cur);
            // Prevent the occurrence of a situation that is exactly 26.
            columnNumber--;
            columnNumber /= 26;
        }

        return ans.reverse().toString();
    }
}