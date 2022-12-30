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
     * 使用辗转相除法求最大公约数
     * @param number1 第一个数字
     * @param number2 第二个数字
     * @return number1和number2的最大公约数
     */
    private int GCD(int number1, int number2) {
        // 递归的结束条件
        if (number1 % number2 == 0 || number2 == 1) {
            return number2;
        }
        // 继续求解最大公约数
        return GCD(number2, number1 % number2);
    }
}