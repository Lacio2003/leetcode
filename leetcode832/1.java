/**
 * 思路：直接按照题目进行暴力破解。先水平翻转然后翻转。
 * 时间复杂度:O(2 * n^2)
 * 空间复杂度:O(1)
 */

class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        // 先水平翻转
        for (int i = 0; i < image.length; i++) {
            // 进行水平翻转
            // 为了方便使用，使用一个变量存储每一行的长度
            int n = image[i].length;
            for (int j = 0; j < n / 2; j++) {
                // 交换两个位置的数字
                image[i][j] ^= image[i][n - 1 - j];
                image[i][n - 1 - j] ^= image[i][j];
                image[i][j] ^= image[i][n - 1 - j];

            }
        }

        // 进行翻转
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                // 利用(一个数^1)来翻转指定位
                image[i][j] ^= 1;
            }
        }

        return image;
    }
}