/*
    在2的基础上进行优化，使用O(1)的空间复杂度

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int countBinarySubstrings(String s) {
        // 准备变量
        int pre = 0;
        int ptr = 0, n = s.length();
        char[] chars = s.toCharArray();

        int ans = 0;
        // 开始统计
        while (ptr < n) {
            char c = chars[ptr];
            // 计算当前字符的数量
            int cur = 0;
            while (ptr < n && chars[ptr] == c) {
                cur++;
                ptr++;
            }

            ans += Math.min(pre, cur);
            pre = cur;
        }

        return ans;
    }
}