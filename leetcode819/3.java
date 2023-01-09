/**
 * Runtime complexity:O(m + n)
 * Space complexity:O(m + n)
 */
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // The banneds stores the elements of the banned.
        Set<String> banneds = new HashSet<>();
        for (String e : banned) {
            banneds.add(e);
        }

        // The hash stores the words of the paragraph and the number of occurrences.
        Map<String,Integer> hash = new HashMap<>();
        // For easy of use, convert String to array.
        char[] arr = paragraph.toCharArray();

        // The ans is final answer.
        String ans = null;
        for (int i = 0; i < arr.length;) {
            // The current character is not a letter, Skip it diectly.
            if (!Character.isLetter(arr[i])) {
                i++;
                continue;
            }

            // Get the current word.
            int begin = i;
            while (i < arr.length && Character.isLetter(arr[i])) {
                i++;
            }

            String curWord = paragraph.substring(begin, i).toLowerCase();
            // The current word is banned word.
            if (banneds.contains(curWord)) {
                continue;
            }
            // The programm can execute here, the current word is not a banned word.
            hash.put(curWord, hash.getOrDefault(curWord, 0) + 1);
            if (null == ans || hash.get(curWord) > hash.get(ans)) {
                ans = curWord;
            }
        }

        return ans;
    }
}