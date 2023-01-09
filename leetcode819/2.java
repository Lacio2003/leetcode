/**
 * Runtime complexity:O(m + n) m is the length of word in the paragraph, n is the length of the banned.
 * Space complexity:O(n)
 */
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // The banneds stores the elements of the banned.
        Set<String> banneds = new HashSet<>();
        for (String e : banned) {
            banneds.add(e);
        }
        // The hash stores the each word and the corresponding number of times.
        Map<String, Integer> hash = new HashMap<>();
        // For eays of use, convert the String to the array.
        char[] arr = paragraph.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (Character.isLetter(arr[i])) {
                // Encounter word.
                // The cur is the begin of the word.
                int cur = i;
                while (i < arr.length && Character.isLetter(arr[i])) {
                    i++;
                }

                // Get the current word.
                String curWord = paragraph.substring(cur, i).toLowerCase();
                if (!banneds.contains(curWord)) {
                    // If the current word is not a banned words.
                    // Put the word in the hash table.
                    hash.put(curWord, hash.getOrDefault(curWord, 0) + 1);
                }
            }
        }

        // Look for the words that appear the most.
        String max = null;
        for (String e : hash.keySet()) {
            if (null == max || hash.get(e) > hash.get(max)) {
                max = e;
            }
        }

        return max;
    }
}