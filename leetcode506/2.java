/**
 * Runtime complexity:O(n + nlogn + n)
 * Space complexity:O(n)
 */
class Solution {
    String[] previouThree = {"Gold Medal", "Silver Medal", "Bronze Medal"};
    public String[] findRelativeRanks(int[] score) {
        // For easy fo use, the length of score.
        int n = score.length;
        // The ranked array. 
        int[] ranks = score.clone();
        Arrays.sort(ranks);

        // The hash stores the score correspondings to the score.
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hash.put(ranks[i], n - i);
        }

        // The ans stores the final answer.
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            int curRank = hash.get(score[i]);
            ans[i] = curRank < 4 ? previouThree[curRank - 1] : String.valueOf(curRank);
        }

        return ans;
    }
}