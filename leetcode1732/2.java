/**
 * 思路：使用递归解决这个问题
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */

class Solution {
    public int largestAltitude(int[] gain) {
        // 递归计算
        recursion(gain, gain.length - 1);
        return max;
    }

    // 存储最高海拔
    int max = 0;
    private int recursion(int[] gain, int index) {
        // 递归结束条件
        if (index == -1) {
            return 0;
        }

        // 计算当前海拔
        int currAltitude = recursion(gain, index - 1) + gain[index];
        // 更新最高海拔
        max = Math.max(max, currAltitude);
        // 返回当前海拔
        return currAltitude;
    }
}