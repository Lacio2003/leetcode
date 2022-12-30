/**
 * According to the requirements of the topic, use the recursive solution method.
 * Time comlexity:O(n^2)
 * Space compexity:O(n)
 */
class Solution {
    public String countAndSay(int n) {
        // The end condition for recursion.
        if (n == 1) {
            return "1";
        }

        // Get the previous string.
        String previous = countAndSay(n - 1);
        // Describes the previous string.
        return describe(previous + "#");
    }

    /**
     * A description string for a number string.
     * @param str The string of numbers begin described.
     * @return A desciption string for a number string.
     */
    private String describe(String str) {
        StringBuilder ans = new StringBuilder();
        int n = str.length();
        for (int i = 0, curNum = 1; i < n - 1; i++, curNum++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                ans.append(curNum);
                ans.append(str.charAt(i));
                curNum = 0;
            }
        }

        return ans.toString();
    }


}