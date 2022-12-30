/**
 * 思路:利用开头和结果，推测出可以通过判断当前元素和反转位置的元素是否相等来选择是否翻转。从而解决了这个问题。
 * 时间复杂度:O(n^2)
 * 空间复杂度:O(1)
 */

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int length = image[i].length;
            // 利用特性进行翻转。
            /*
                如果一个元素和交换位置的数字不相等相等。那么最后的结果依然是原来的结果。
                如果一个元素和交换位置的数字相等，那么最后的结果就是翻转之后的结果。
             */
             // 从后往前遍历
             for (int j = length - 1; j >= length / 2; j--) {
                 if (image[i][j] == image[i][length - 1 - j]) {
                    image[i][j] ^= 1;
                    // 将翻转之后的制定为赋值为要交换的位置，这样可以简化代码。
                    image[i][length - 1 - j] = image[i][j];
                 }
             }
        }

        return image;
    }
}