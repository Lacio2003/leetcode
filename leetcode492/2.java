/**
 * Start with the sqrt of number, look from the largest to the smallest.
 * Runtime complexity:O(根号n)
 * Space complexity:O(1)
 */
class Solution {
    public int[] constructRectangle(int area) {
        int i = (int)Math.sqrt(area);
        while (area % i != 0) {
            i--;
        }

        return new int[]{area / i, i};
    }
}