/*
    提前构造出s字符串
    计算前n个字符串

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int magicalString(int n) {
        // 构造s字符串
        // 记录s字符串的数组
        char[] s = new char[n + 3];
        s[0] = '1';
        s[1] = '2';
        s[2] = '2';

        // 构造的字符串
        char[] c = {'1', '2'};
        int pC = 0;
        for (int i = 2, j = 3; j < n; i++) {
            int count = s[i] - '0';
            while (count --> 0) {
                s[j++] = c[pC];
            }
            pC = (pC + 1) % 2;
        }

        // 计算前n个字符串中1的个数
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') {
                ans++;
            }
        }

        return ans;
    }
}