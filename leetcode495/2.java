/**
 * Calculate the total duration of toxicity and subtract the duplicates.
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // The total stores the total seconds.
        int total = timeSeries.length * duration;
        for (int i = 1; i < timeSeries.length; i++) {
            if (timeSeries[i] - timeSeries[i - 1] < duration) {
                // Subtract the time of repetition.
                total -= duration - (timeSeries[i] - timeSeries[i - 1]);
            }
        }

        return total;
    }
}