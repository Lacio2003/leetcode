/**
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public boolean checkRecord(String s) {
        // The countA stores the number of absent.
        // The countL stores the number of late.
        int countA = 0, countL = 0;
        // For easy of use, the length of s is stored in a variable.
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            countL = cur == 'L' ? countL + 1 : 0;
            if (cur == 'A') {
                countA++;
            }
            // Two days absence or late for three days in a row.
            if (countA >= 2 || countL >= 3) {
                return false;
            }
        }

        return true;

    }
}