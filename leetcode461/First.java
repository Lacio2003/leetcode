class Solution {
    public int hammingDistance(int x, int y) {
        /*
         * 思路：因为要求两个数字二进制不同位数的个数。所以可以考虑先求出两个数字的异或结果，然后
         * 不断检查异或结果的最后一位。如果最后一位为1，那么将答案加一。然后将异或结果右移一位，再次检查最后一位。循环往复直至最后结果为0。
         */

        // num代表两个数的异或结果。
        // ans存储共有多少不同位数。
        int num = x ^ y, ans = 0;
        // 遍历异或结果
        while (num > 0) {
            // 检查最后一位是否是1。如果是1，加一，否则加0(没加)。
            ans += num & 1;
            // 将异或结果右移一位。
            num >>= 1;
        }
        return ans;
    }
}