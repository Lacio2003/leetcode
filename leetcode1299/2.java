/**
 * 思路：我们发现正序遍历的花费的时间至少是O(n^2)，所以，我们采用逆序遍历。从后往前遍历同时记录最大值。
 * O(n)
 * O(1)
 */

class Solution {
    public int[] replaceElements(int[] arr) {
        // 为了方便后面的使用，将长度储存再一个变量n当中
        int n = arr.length;
        // 存放最大值
        int max = -1;
        // 逆序遍历
        for (int i = n - 1; i >= 0; i--) {
            // 临时变量存储当前值
            int temp = arr[i];
            arr[i] = max;
            // 更新最大值
            if (temp > max) {
                max = temp;
            }
        }

        return arr;
    }
}