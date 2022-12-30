/** 
 * 思路：反向求解，余数从0到1，所以可以分别寻找满足这些余数的下标，并检查。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
*/
class Solution {
    public int smallestEqual(int[] nums) {
        int min = 101;
        // i代表余数，从0到1
        for (int i = 0; i < 10; i++) {
            // 寻找符合当前余数的下标
            // 如果余数是0的话，则符合的下标为0, 10, 20
            // 如果余数是1的话，则符合的下标为1, 11, 21
            // ...
            for (int k = i; k < min && k < nums.length; k += 10) {
                if (nums[k] == i) {
                    // 当前下标符合条件，更新最小值
                    min = k;
                    // 因为要寻找最小的下标，停止就可以了
                    break;
                }
            }
        }

        return min < 101 ? min : -1;
    }
}