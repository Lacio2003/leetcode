/**
 * 思路：据观察，可以看到结果的最小值为(四位数两个最小值)*10 + (四位数中两个最大值)
 * 1.将四位数转换为数组
 * 2.对数组进行排序
 * 3.直接然会结果 
 */
class Solution {
    public int minimumSum(int num) {
        // 将四位数转换为数组
        int[] array = conversion(num);
        // 对数组进行排序，找到其中最小的两个值
        Arrays.sort(array);
        // 返回(两个最小值的和)*10+(两个最大值的和)
        return (array[0] + array[1]) * 10 + array[2] + array[3];
    }

    
    /**
     * @param num 要转换的四位数
     * @return int[] 返回为四位数的数组
     */
    private int[] conversion(int num) {
        // 存储各个位上的数字的数组
        int[] ans = new int[4];
        // 将四位上的数字一一读取到数组当中
        for (int i = 3; num > 0; i--) {
            ans[i] = num % 10;
            num /= 10;
        }
        return ans;
    }
}