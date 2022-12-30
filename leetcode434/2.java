class Solution {
    public int countSegments(String s) {
        // The ans stores the final answer.
        int ans = 0;
        for (int i = s.length() - 1; i > -1;) {
            // Skip the ' '.
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }
            // Skip the word.
            while (i > -1 && s.charAt(i) != ' ') {
                i--;
            }
            // The number of words is increased by one.
            ans++;
        }

        return ans;
    }
}