/**
 * @date 2022年11月07日
 * @author think
 */
public class First {
    /**
     * 使用BrianKernighan算法统计一个数字二进制表示中1的个数
	 * 时间复杂度：O(logN)
	 * 空间复杂度：O(1)
     * @param e 需要统计的数字(可以是负数，也可以是整数)
     * @return 数字二进制表示中1的个数
     */
    public static int countNumberOfOne(int e) {
        int count = 0;
        // 这里不可以写e > 0。因为如果e是负数，就不会执行循环。那么结果就是错误的。
        while (e != 0) {
            count++;
            // 使用BrianKernighan算法，每次让当前数字二进制的最右边的1变成0
            e &= e - 1;
        }
        return count;
    }
}
