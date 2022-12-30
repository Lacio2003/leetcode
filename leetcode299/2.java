/**
 * Use two methods to find bulls and cows separately.
 * Just look for the bulls and check each position in turn.
 * Look for the cows:
 * Use a hash table to store the numbers inside the secret, and then iterate through the guess, if a number exits in the hash table, substract the number of times and increase the number of cows.
 * Time complexity:O(n)
 * Space compexity:O(2 * n)
 */
class Solution {
    public String getHint(String secret, String guess) {
        return getBull(secret, guess) + "A" + getCows(secret, guess) + "B";
    }

    // The position stores the positions of Bulls.
    Set<Integer> positions = new HashSet<>();
    /**
     * Get the Bulls.
     */
    private int getBull(String secret, String guess) {
        // The number of the Bulls.
        int count = 0;
        for (int i = secret.length() - 1; i >= 0; i--) {
            char fir = secret.charAt(i), sec = guess.charAt(i);
            if (fir == sec) {
                // Eligible for Bulls.
                // Record the position of the Bulls.
                positions.add(i);
                count++;
            }
        }

        return count;
    }

    /**
     * Get the Cows.
     */
    private int getCows(String secret, String guess) {
        // The hash stores the numbers of secret.
        int[] hash = new int[10];
        for (int i = secret.length() - 1; i > -1; i--) {
            if (positions.contains(i)) {
                // Numbers that do not record the positions of Bulls.
                continue;
            }
            char cur = secret.charAt(i);
            hash[cur - '0']++;
        }

        // The number of cows.
        int count = 0;
        for (int i = guess.length() - 1; i > -1; i--) {
            // The position of the bull is not record.
            if (positions.contains(i)) {
                continue;
            }
            int cur = guess.charAt(i) - '0';
            if (hash[cur] > 0) {
                count++;
                hash[cur]--;
            }
        }

        return count;
    }
}