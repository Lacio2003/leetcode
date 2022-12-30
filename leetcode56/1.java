/**
 * Sort the interval array first.If the interval can be comblied, merge interval.If the interval cannot be comblined, the current interval join the array directly.
 * Runtime complexity:O(nlogn + n)
 * Space complexity:O(n)
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        // Sort the intervals.
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // The index of ans.
        int idx = -1;
        // The ans stores the final answer.
        int[][] ans = new int[intervals.length][2];
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > ans[idx][1]) {
                // The current interval cannot be combined.
                ans[++idx] = interval;
            } else {
                // The current interval can be comblied.
                // Select the largest right boundary.
                ans[idx][1] = Math.max(ans[idx][1], interval[1]);
            }
        }

        return Arrays.copyOf(ans, idx + 1);
    }
}