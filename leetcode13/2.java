/**
 * Idea:When the large character is in front of the small character,the addition operation is performed, and when the small character is in front of the large character,the substraction is performed.
 * Time complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    Map<Character, Integer> table = new HashMap<>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};
    public int romanToInt(String s) {
        // For easy for use, Converts the String s to the char array.
        char[] array = s.toCharArray();
        // The ans stores the final numbers.
        int ans = 0;
        for (int i = 0; i < array.length; i++) {
            int cur = table.get(array[i]);
            if (i < array.length - 1 && cur < table.get(array[i + 1])) {
                // Small character are in font of large characters, and the operation is subtracted.
                cur = -cur;
            }
            // Add the current number.
            ans += cur;
        }

        return ans;
    }
}