/**
 * 如果num是一个负数。那么可以转换为他的补码对应的正数。那么方便我们统一处理。
 * 之后，按照进制转换的方法。将10进制转换为16进制。
 * Runtime complexity:O(8),16进制的位数最多为8位。
 * Space complexity:O(8)
 */
class Solution {
    public String toHex(int num) {
        // If the nums if 0, return 0 directly.
        if (num == 0) {
            return "0";
        }
        // 将num装换为long类型，目的是为了将负数的num转换为正数。
        long number = num;
        if (number < 0) {
            // 如果num是负数，转换为正数。
            number = (long)(Math.pow(2, 32) + number);
        }

        // 存储答案的StringBuilder。
        StringBuilder ans = new StringBuilder();
        while (number > 0) {
            // 取出当前位置。
            long cur = number % 16;
            // 转换为数字。
            char c = (char)(cur + '0');
            if (cur > 9) {
                // 如果cur大于10，转换为16进制字符。
                c = (char)(cur - 10 + 'a');
            }
            ans.append(c);
            number /= 16;
        }

        return ans.reverse().toString();
    }
}