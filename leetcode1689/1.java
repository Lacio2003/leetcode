/*
    贪心算法:将这些数字比作一座连绵的山，要想将山夷平，需要最高的山峰。
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for (char c : n.toCharArray()) {
            int digit = c - '0';
            // 找出最高的山峰
            max = Math.max(digit, max);
        }

        return max;
    }
}