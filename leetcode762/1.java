/**
 * Runtime complexity:O(n)
 * Space complexity:O(C)
 */
class Solution {
    // Prime numbers from 1 to 2.
    private static Set<Integer> hash = new HashSet<>(){{
        add(2);
        add(3);
        add(5);
        add(7);
        add(11);
        add(13);
        add(17);
        add(19);
        add(23);
        add(29);
        add(31);
    }};
    public int countPrimeSetBits(int left, int right) {
        // The count storeds the final answer.
        int count = 0;
        for (int i = left; i <= right; i++) {
            // The number of one-bits of the current number.
            int curCount = Integer.bitCount(i);
            if (hash.contains(curCount)) {
                // The number of one-bits of the current number is a prime.
                count++;
            }
        }

        return count;
    }
}