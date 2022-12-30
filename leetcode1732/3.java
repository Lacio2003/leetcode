/**
 * 思路：按照题目要求，依次求出海拔，然后通过比较求出最大值
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */

class Solution {
    public int largestAltitude(int[] gain) {
        // 存储最大海拔
        int max = 0;
        // 当前海拔
        int currAltitude = 0;

        // 计算海拔并找出最大海拔
        for (int i = 0; i < gain.length; i++) {
            // 计算海拔
            currAltitude += gain[i];
            // 更新最大值
            max = currAltitude > max ? currAltitude : max;
        }

        return max;
    }
}