class Solution {
    public int hammingDistance(int x, int y) {
        /*
         * 思路：
         * 1.求出两个数异或的结果。
         * 2.计算异或结果中1的个数。
         */

        // 直接使用Java中内置的方法计算1的个数。
        return Integer.bitCount(x ^ y);
    }
}