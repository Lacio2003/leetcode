/**
 * 思路：根据题意可得，两个数如果是偶数和奇数的话，那么筹码为0。所以一开始的移动
 * 看成从一个位置的偶数(奇数)上移动到奇数(偶数)上。所以，结果为非有两种情况。从
 * 奇数上移动到偶数上，从偶数上移动到奇数上。那个小返回哪一个。
 * 步骤：统计偶数和奇数的数量，返回最小值即可
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
class Solution {
    public int minCostToMoveChips(int[] position) {
        // 偶数的数量和奇数的数量
        int oddNumber = 0, evenNumber = 0;

        // 遍历数组，统计偶数和奇数的数量
        for (int e : position) {
            if ((e & 1) == 0) {
                evenNumber++;
                continue;
            }
            oddNumber++;
        }

        // 返回奇数和偶数的数量中最小值
        return evenNumber < oddNumber ? evenNumber : oddNumber;
    }
}