/*
    思路:
    1.将数字转换为对应的进制的字符串
    2.利用双指针进行判断，是否是一个回文字符串，如果是返回true，否则返回false。

    时间复杂度:O(m * n),m是进制的个数
    空间复杂度:O(1)
*/
class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            // 1.将数字转换为对应的进制的字符串
            String curRadix = convert(n, i);
            System.out.println(curRadix);
            // 2.判断这个字符串是不是回文串
            // 将字符串转换为字符数组
            char[] chars = curRadix.toCharArray();
            // 使用双指针进行判断
            for (int left = 0, right = chars.length - 1; left <= right; left++, right--) {
                if (chars[left] != chars[right]) {
                    return false;
                }
            }
        }

        return true;
    }

    private String convert(int n, int radix) {
        // 1.准备存储字符串的容器
        StringBuilder ans = new StringBuilder();
        // 2.遍历数字，进行转换
        while (n > 0) {
            int cur = n % radix;
            ans.append(cur);
            n /= radix;
        }

        return ans.toString();
    }
}