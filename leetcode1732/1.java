/**
 * 思路：按照题目暴力破解，利用题目给的条件还原原来的数组，找到最大值
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */

class Solution {
    public int largestAltitude(int[] gain) {
        // 为了方便使用，将gain的长处存储在变量n当中
        int n = gain.length + 1;
        // 存储海拔的数组
        int[] altitude = new int[n];

        // 计算出各个海拔
        for (int i = 1; i < n; i++) {
            altitude[i] = altitude[i - 1] + gain[i - 1];
        }


        // 返回最大值
        return Arrays.stream(altitude).max().getAsInt();
    }
}