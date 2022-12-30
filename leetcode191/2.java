public class Solution {
    /**
     * 统计数字n当中的二进制表示中的1的个数。(负数按补码形式进行计算)
     * @param n n是32位二进制的数字
     * @return n中的二进制表示中的1的个数
     */
    public int hammingWeight(int n) {
        int count = 0;
        // 因为存在负数，在下面这种方式下，不能直接通过判断n的值来停止循环。所以只能
        // 遍历32次。
        for (int i = 0; i < 32; i++) {
            count += (n & 1);
            n >>= 1;
        }
        return count;
    }
}