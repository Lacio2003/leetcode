/**
 * Paragraph by paragraph comparision.
 * Time complexity:O(n + m);
 * Space compleixty:O(1)
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        // For easy of use, the length of version1 and version2 is stored in variable.
        int len1 = version1.length(), len2 = version2.length();

        for (int i = 0, j = 0; i < len1 || j < len2;) {
            // Get the current revision number.
            int e1 = get(version1, i), e2 = get(version2, j);
            // Convert the current revision number to number.
            int num1 = e1 == 501 ? 0 : Integer.valueOf(version1.substring(i, e1));
            int num2 = e2 == 501 ? 0 : Integer.valueOf(version2.substring(j, e2));

            // Compare two numbers.
            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }

            i = e1 + 1;
            j = e2 + 1;
        }

        return 0;
    }

    /**
     * Get the revision number.
     */
    private int get(String str, int begin) {
        int len = str.length();
        // The length of begin is more than length. 
        if (begin >= len) {
            return 501;
        }

        while (begin < len && str.charAt(begin) != '.') {
            begin++;
        }

        return begin;
    }
}