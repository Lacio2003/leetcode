/**
 * Improvement the basic of 1.Use a hash table to store the frequency of each word and the length of each word.The same frequency is stored the longest length.
 * Time complexity:O(n^2)
 * Spcae complexity:O(n)
 */
class Solution {
    public int maxProduct(String[] words) {
        // The map stores the frequency of each word and the length of each word.
        Map<Integer, Integer> map = new HashMap<>();
        for (String s : words) {
            int t = 0;
            int len = s.length();
            // Get the frequency of the current word.
            for (int i = 0; i < len; i++) {
                int cn = s.charAt(i) - 'a';
                t |= 1 << cn;
            }
            if (!map.containsKey(t) || map.get(t) < len) {
                // The same frequency is stored the longest.
                map.put(t, len);
            }
        }

        // The max stored the final answer.
        int max = 0;
        for (int a : map.keySet()) {
            for (int b : map.keySet()) {
                if ((a & b) == 0) {
                    // Update the max.
                    max = Math.max(max, map.get(a) * map.get(b));
                }
            }
        }

        return max;
    }
}