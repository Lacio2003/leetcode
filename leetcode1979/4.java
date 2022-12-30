class Solution {
    public int findGCD(int[] nums) {
        // 求出nums当中的最大数和最小数
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for (int e : nums) {
            // 更新最大值
            max = e > max ? e : max;
            // 更新最小值
            min = e < min ? e : min;
        }

        // 最大公约数
        return GCD(max, min);
    }

    /**
     * 使用Stein算法求最大公约数
     * 必须要判断number1和number2哪一个更大，否则将会发生错误。
     * @param number1 第一个数字
     * @param number2 第二个数字
     * @return number1和number2的最大公约数
     */
    private int GCD(int number1, int number2) {
        // 递归结束条件
        if (number1 == number2) {
            return number1;
        } else if ((number1 & 1) == 1 && (number2 & 1) == 1) {
            // 两个数都是奇数，使用更相减损法
            if (number1 > number2) {
                return GCD(number2, number1 - number2);
            } else {
                // number2 > number1
                return GCD(number1, number2 - number1);
            }
        } else if((number1 & 1) == 0 && (number2 & 1) == 0){
            // 两个数都是偶数
            return GCD(number1 >> 1, number2 >> 1) << 1;
        } else {
            // 其他的情况
            return GCD(((number1 & 1) == 0 ? number1 >> 1 : number1),((number2 & 1) == 0 ? number2 >> 1 : number2));
        }

    }
}