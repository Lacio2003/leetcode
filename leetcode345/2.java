/**
 * Get the positions of vowels in the string.Then swap the position of the vowels.
 * Time complexity:O(n)
 * Space complexity:O(n)
 */
class Solution {
    // The hahs stores the vowels.
    Set<Character> hash = new HashSet<>(){{
        add('a');
        add('e');
        add('i');
        add('o');
        add('u');
    }};
    public String reverseVowels(String s) {
        // The positions stores the position of the vowels in the s.
        List<Integer> positions = new ArrayList<>();
        // For easy of use, Convert the s to the character array.
        char[] arr = s.toCharArray();

        // Get the position of the vowels character in the string.
        for (int i = 0; i < arr.length; i++) {
            // Convert to all chatacters to the lowercase character. 
            char cur = Character.toLowerCase(arr[i]);
            if (hash.contains(cur)) {
                // The current character is a vowel.
                positions.add(i);
            }
        }

        // Swap the position of the vowel.
        for (int i = 0, j = positions.size() - 1; i < j; i++, j--) {
            swap(arr, positions.get(i), positions.get(j));
        }

        return new String(arr);
    }

    /**
     * Swap the position of two character in the character array.
     */
    private void swap(char[] arr, int a, int b) {
        if (arr[a] != arr[b]) {
            char c = arr[a];
            arr[a] = arr[b];
            arr[b] = c;
        }
    }
}