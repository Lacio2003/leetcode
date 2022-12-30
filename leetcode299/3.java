/**
 * Look for bulls to compare the numbers on the two positions on it.
 * The frequency of occurrence of the two numbers is recorded separately, the smallest being the number of cows.
 * Time complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public String getHint(String secret, String guess) {
        // For easy of use, the length of secret is stored in a variable.
        int len = secret.length();

        // The cn1 stores how often the number appears.
        // The cn2 stores how often the number appears.
        int[] cn1 = new int[10], cn2 = new int[10];
        // The number of Bulls.
        int bulls = 0;
        for (int i = 0; i < len; i++) {
            int fir = secret.charAt(i) - '0', sec = guess.charAt(i) - '0';
            if (fir == sec) {
                // The current number is Bull.
                bulls++;
            } else {
                cn1[fir]++;
                cn2[sec]++;
            }
        }

        // The number of cows.
        int cows = 0;
        for (int i = 0; i < 10; i++) {
            //Take the minimum value. 
            cows += Math.min(cn1[i], cn2[i]);
        }

        return bulls + "A" + cows + "B";
    }
}