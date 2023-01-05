/**
 * Runtime complexity:O(n^2)
 * Space complexity:O(C)
 */
class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // Get the frequent array of the licensePlate.
        int[] liceFre = getFrequent(licensePlate);
        // The answer string.
        String ans = null;
        for (String e : words) {
            // Get the frequent array of the current string.
            int[] curFreq = getFrequent(e);
            boolean is = true;
            for (int i = 0; i < 26; i++) {
                if (curFreq[i] < liceFre[i]) {
                    // The current string is eligible.
                    is = false;
                    break;
                }
            }

            if (is && (ans == null || e.length() < ans.length())) {
                ans = e;
            }
        }

        return ans;
    }

    /**
     * Get the frequent array of the s.
     */
    private int[] getFrequent(String s) {
        int[] frequent = new int[26];
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                frequent[Character.toLowerCase(c) - 'a']++;
            }
        }

        return frequent;
    }
}