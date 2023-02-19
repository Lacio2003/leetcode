/*
    一次构造出10^5次方的s字符串，然后求取前缀和，返回结果。

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    // 最大的长度
    private static final int MX = (int)1e5;
    // 1个数的前缀和数组
    private static final int[] preSum = new int[MX + 1];

    static {
        // 存放s的数组
        char[] s = new char[MX + 1];
        s[0] = 1;
        s[1] = s[2] = 2;

        // 构造s字符串
        char c = 2;
        for (int i = 2, j = 3; j < MX; i++) {
            c ^= 3;
            s[j++] = c;
            if (s[i] == 2) {
                s[j++] = c;
            }
        }

        // 填充前缀和数组
        for (int i = 0; i < MX; i++) {
            preSum[i + 1] = preSum[i] + 2 - s[i];
        }
    }

    public int magicalString(int n) {
        return preSum[n];
    }
}