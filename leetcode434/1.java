/**
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int countSegments(String s) {
        // The sum stores the final answer.
        // Use the count to store the every word.
        int sum = 0, count = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) != ' ') {
                // Encounter word.
                count = 1;
            } else {
                // Encounter " "
                sum += count;
                count = 0;
            }
        }

        // The head word is not a " ";
        if (count != 0) {
            sum++;
        }

        return sum;
    }
}