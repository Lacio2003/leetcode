/**
 * @date 2022-11-10
 * @author think
 */
public class Third {
    /**
     * 计算n二进制表示当中1的个数(如果是负数，按照补码进行计算)
     * @param n n的二进制位32，可以是正数，也可以是负数。
     * @return n的二进制为当中的1的个数
     */
    public static int hammingWeight(int n) {
        // 统计1的个数
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            // 注意这里是逻辑右移>>>，如果使用算术右移>>，高位会填充符号位。如果是负数，会一直是-1。
            // 最后就会死循环。
            n >>>= 1;
        }

        return count;
    }
}
