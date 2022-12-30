/**
 * website:https://leetcode.cn/problems/teemo-attacking/solutions/1093486/gong-shui-san-xie-jian-dan-mo-ni-ti-by-a-gteh/
 * Runtime complexity:O(n)
 * Space complexity:O(1)
 */
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        // The ans stores the total seconds.
        // The last stores the last time each attack toxicity lasts.
        int ans = 0, last = -1;
        for (int i = 0; i < timeSeries.length; i++) {
            int curEnd = timeSeries[i] + duration - 1;
            // Get the current seconds.
            ans += last < timeSeries[i] ? duration : curEnd - last;
            last = curEnd;
        }

        return ans;
    }
}