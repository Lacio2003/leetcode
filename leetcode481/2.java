/*
    1的另一种写法

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int magicalString(int n) {
        // 构造s字符串
        char[] s = new char[n + 3];
        s[0] = 1;
        s[1] = s[2] = 2;

        char c = 2;
        for (int i = 2, j = 3; j < n; i++) {
            // 2 ^ 3 = 1, 1 ^ 3 = 2;
            c ^= 3;
            s[j++] = c;
            if (s[i] == 2) {
                s[j++] = c;
            }
        }

        // 统计1的个数
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += 2 - s[i];
        }

        return ans;
    }
}