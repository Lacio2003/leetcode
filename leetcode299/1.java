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
        Map<Character, Integer> hash = new HashMap<>();
        for (int i = secret.length() - 1; i > -1; i--) {
            if (positions.contains(i)) {
                // Numbers that do not record the positions of Bulls.
                continue;
            }
            char cur = secret.charAt(i);
            hash.put(cur, hash.getOrDefault(cur, 0) + 1);
        }

        // The number of cows.
        int count = 0;
        for (int i = guess.length() - 1; i > -1; i--) {
            // The position of the bull is not record.
            if (positions.contains(i)) {
                continue;
            }
            char cur = guess.charAt(i);
            if (hash.containsKey(cur) && hash.get(cur) > 0) {
                // Cows are present.
                count++;
                hash.put(cur, hash.get(cur) - 1);
            }
        }

        return count;
    }
}