/**
 * Idea:Adopt official practices.Determine the current status and handle it.
 * Time complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int myAtoi(String s) {
        Automan automan = new Automan();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            automan.get(s.charAt(i));
        }

        return (int)(automan.ans * automan.sign);
    }
}

class Automan{
    /**
     * The sign of the number.
     */
    public int sign = 1;
    /**
     * Store the number.
     */
    public long ans = 0;
    /**
     * The current status.
     */
    private String state = "start";

    /**
     * Store the automan.
     */
    private HashMap<String, String[]> table = new HashMap<>(){{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    /**
     * Get the current status and processing.
     */
    public void get(char c) {
        // Get the current status.
        state = table.get(state)[getState(c)];
        // If status is number.Store the number.
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min((long)Integer.MAX_VALUE, ans) : Math.min(-(long)Integer.MIN_VALUE, ans);
        } else if ("signed" == state) {
            // Process the symbols.
            sign = c == '+' ? 1 : -1;
        }
    }

    /**
     * Get the current status.
     * @param c The current character.
     * @return The position of the status.
     */
    private int getState(char c) {
        if (c == ' ') {
            return 0;
        } else if (c == '+' || c == '-') {
            return 1;
        } else if (Character.isDigit(c)) {
            return 2;
        }

        return 3;
    }
}