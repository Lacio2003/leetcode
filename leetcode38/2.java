/**
 * According to the requirements of the topic, use the loop solution method.
 * Time comlexity:O(n^2)
 * Space compexity:O(1)
 */
class Solution {
    public String countAndSay(int n) {
        // The ans stores the a string that describes.
        String ans = "1";
        // Loop solving.
        for (int i = 1; i < n; i++) {
            ans = describe(ans + "#");
        }
        return ans;
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