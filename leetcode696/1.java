/*
    使用两个变量，一个是numZero, 一个是numOne。使用两个指针分别统计0和1的数量

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int countBinarySubstrings(String s) {
        // 定义变量
        int numZero = 0, numOne = 0;
        // 开始遍历
        // left统计0的个数
        // right统计1的个数
        int left = 0, right = 0;

        char[] chars = s.toCharArray();
        int n = chars.length;
        int ans = 0;
        while (left < n && right < n) {
            // 统计0的个数
            while (left < n && chars[left] == '0') {
                numZero++;
                left++;
            }
            right = left;
            if (numZero > 0 && numOne > 0) {
                ans += Math.min(numOne, numZero);
                numOne = 0;
            }
            // 统计1的个数
            while (right < n && chars[right] == '1') {
                numOne++;
                right++;
            }

            if (numZero > 0 && numOne > 0) {
                ans += Math.min(numOne, numZero);
                numZero = 0;
            }

            left = right;
        }

        return ans;
    }
}