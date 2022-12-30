/**
 * Idea:Placing the code in a static code block and save some time complexity and space complexity.
 * Time complexity:O(1).The code is placed locally and does not need to executed repeatedly, so the time complexity is O(1)
 * Space complexity:O(C)
 */
class Solution {
    // The arrya of f store the descible string.
    static String[] f = new String[31];

    // Fill the f array.
    static {
        f[1] = "1";
        for (int i = 2; i <= 30; i++) {
            StringBuilder cur = new StringBuilder();
            String pre = f[i - 1] + "#";
            int len = pre.length();
            for (int j = 0, curNum = 1; j < len - 1; j++, curNum++) {
                if (pre.charAt(j) != pre.charAt(j + 1)) {
                    cur.append(curNum).append(pre.charAt(j));
                    curNum = 0;
                }
            }

            f[i] = cur.toString();
        }
    }

    public String countAndSay(int n) {
        return f[n];
    }
}