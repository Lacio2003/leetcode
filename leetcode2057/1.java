/**
 * 思路：利用余数来寻找下标。
 * 事先准备三个变量，一个变量代表余数,即下标除以10的结果(i)，一个变量代表下标(k)，一个变量存储最后的答案(min)
 * 当i == 0，寻找0, 10, 20, 30... (实际上就是寻找下标除以10等于0的下标)
 * 当i == 1，寻找下标除以10等于1的下标
 * 以此类推...
 * 每一次符合条件，就更新min。最后返回结果既可。
 */
class Solution {
    public int smallestEqual(int[] nums) {
        // i代表代表余数
        // k代表数组的下标,
        // min代表符合条件的最小值
        int i = 0, k = 0, min = 101;

        // 因为余数从0到9，所以条件是i < 10
        while (i < 10) {
            // 下标已经超过最小值的下标和数组的长度，寻找下一个余数
            if (k >= min || k >= nums.length) {
                i++;
                k = i;
                continue;
            }

            // 判断下标和余数是否相等
            if (i == nums[k]) {
                // 相等则更新
                min = k;
                // 寻找下一个余数
                i++;
                k = i;
            } else {
                // 不符合条件，寻找下一个下标
                k += 10;
            }
        }

        return min < 101 ? min : -1;
    }
}