/*
    对两个数组排序，然后使用双指针指向两个数组，一个p，一个是t
    p > t，那么移动t
    p <= t，那么记录一次答案，两个指针同时移动

    时间复杂度:O(nlogn + mlogn)
    空间复杂度:O(1)
*/
class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        // 对两个数组进行排序
        Arrays.sort(players);
        Arrays.sort(trainers);

        // 双指针遍历
        int ans = 0;
        for (int i = 0, j = 0; i < players.length && j < trainers.length; j++) {
            if (players[i] <= trainers[j]) {
                ans++;
                i++;
            }
        }

        return ans;
    }
}