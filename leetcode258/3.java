/**
 * The result that the original number is remainder of 9.
 * Because 9 is special. So the original number is subtracted by 1, and the remainder is added by 1.
 * website:https://leetcode.cn/problems/add-digits/solutions/135092/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-7/
 * Time complexity:O(1)
 * Space complexity:O(1) 
 */
class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}