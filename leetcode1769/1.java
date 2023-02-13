/*
    暴力破解:遍历每一个位置，双重for循环，计算每一个位置上的移动次数

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int[] minOperations(String boxes) {
        // 准备工作
        char[] chars = boxes.toCharArray();
        int n = chars.length;
        int[] ans = new int[n];

        // 开始遍历
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (chars[j] == '1') {
                    ans[i] += Math.abs(j - i);
                }
            }
        }

        return ans;
    }
}