/**
 * Convert the number to the two bit First.Then convert the two bit to the hexadecimal.
 * Runtime complexity:O(32)
 * Space complexity:O(C);
 */
class Solution {
    // The hexadeciaml hash table.
    Map<Integer, String> hash = new HashMap<>(){{
        put(10, "a");
        put(11, "b");
        put(12, "c");
        put(13, "d");
        put(14, "e");
        put(15, "f");
    }};
    public String toHex(int num) {
        // If nums is 0, return "0" directly.
        if (num == 0) {
            return "0";
        }
        // Stores a sum of 4 bits.
        int sum = 0;
        // The pos is used to record the number of time.
        int pos = 0;
        StringBuilder ans = new StringBuilder();
        while (num != 0) {
            // Get the current position.
            int cur = num & 1;
            // Convert the decimal.
            cur <<= pos++;
            sum += cur;
            if (pos == 4) {
                // 4-digit record.
                ans.append(sum > 9 ? hash.get(sum) : sum);
                sum = pos = 0;
            }
            num >>>= 1;
        }

        // If the last place is less than 4 places.
        if (pos != 0) {
            ans.append(sum > 9 ? hash.get(sum) : sum);
        }

        return ans.reverse().toString();
    }
}