/**
 * Runtime complexity:O(n + nlogn + n)
 * Space complexity:O(n)
 */
class Solution {
    String[] prevThree = {"Gold Medal", "Silver Medal", "Bronze Medal"};
    public String[] findRelativeRanks(int[] score) {
        // For easy of use, the length of score is stored in a variable.
        int n = score.length;
        // The ranks array.
        int[][] ranks = new int[n][2];

        for (int i = 0; i < n; i++) {
            ranks[i][0] = score[i];
            ranks[i][1] = i;
        }

        // Sort the ranks.
        Arrays.sort(ranks, (a, b) -> (b[0] - a[0]));

        // The ans stores the final answer.
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[ranks[i][1]] = i < 3 ? prevThree[i] : String.valueOf(i + 1);
        }

        return ans;
    }
}