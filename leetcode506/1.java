/**
 * Runtime complexity:O(n + nlogn + n)
 * Space complexity:O(n)
 */
class Solution {
    public String[] findRelativeRanks(int[] score) {
        // For easy of use, the length of score is stored in a variable.
        int n = score.length;
        // An array of score rankings.
        int[] ranks = Arrays.copyOf(score, n);
        // Sort the socre.
        Arrays.sort(ranks);

        // The ans stores the final answer.
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            // Get the current player's ranking.
            int curRank = n - Arrays.binarySearch(ranks, score[i]);
            if (curRank < 4) {
                // 1 to 3 people.
                switch (curRank) {
                    case 1 : 
                        ans[i] = "Gold Medal";
                        break;
                    case 2 : 
                        ans[i] = "Silver Medal";
                        break;
                    case 3 : 
                        ans[i] = "Bronze Medal";
                        break;
                }
            } else {
                // 4 to last place.
                ans[i] = String.valueOf(curRank); 
            }
        }
        return ans;
    }
}