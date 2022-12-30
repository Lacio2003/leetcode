/**
 * 思路:按照题目进行暴力破解。
 * 时间复杂度:O(n^2)
 * 空间复杂度:O(1)
 */

class Solution {
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 寻找最大值
            int max = Integer.MIN_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                }
            }
            // 判断是否是最后一个元素，最后一个元素赋值-1
            arr[i] = (max == Integer.MIN_VALUE ? -1 : max);
        }

        return arr;
    }
}