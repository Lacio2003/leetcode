/**
 * The largest area must be the double-counted area.
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        for (int[] e : ops) {
            m = Math.min(m, e[0]);
            n = Math.min(n, e[1]);
        }

        return m * n;
    }
}