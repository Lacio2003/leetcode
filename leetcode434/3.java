class Solution {
    public int countSegments(String s) {
        // The ans stores the final answer.
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            // If the previous character was a space, it is a new word.
            if ((i == s.length() - 1 || s.charAt(i + 1) == ' ') && s.charAt(i) != ' ') {
                ans++;
            }
        }

        return ans;
    }
}