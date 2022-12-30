/**
 * Look back to front, looking for the most recent result.
 * Runtime complexity:O(n) The n is the size of the area.
 * Space complexity:O(1)
 */
class Solution {
    public int[] constructRectangle(int area) {
        // The length of area.
        int l = area;
        for (int i = l; i > 0; i--) {
            if (area % i == 0 && i >= area / i) {
                // Record the most recent score.
                l = i;
            }
        }

        return new int[]{l, area / l};
    }
}