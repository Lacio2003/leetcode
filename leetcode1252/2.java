/**
 * 思路：因为是要对行和列进行加一。所以，可以使用rows来存储行加一的结果，使用cols来存储列加一的结果。
 * 时间复杂度：q + m + n
 * 空间复杂度：O(m + n)
 */

class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        // 行数组
        int[] rows = new int[m];
        // 列数组
        int[] cols = new int[n];

        // 遍历indices，对对应的行和列进行加一
        for (int[] indice : indices) {
            // 对应的行加一
            rows[indice[0]]++;
            // 对应的列加一
            cols[indice[1]]++;
        }


        int oddr = 0, oddm = 0;
        // 统计rows当中奇数的个数
        for (int i : rows) {
            if ((i & 1) == 1) {
                oddr++;
            }
        }
        // 统计cols中偶数的个数
        for (int i : cols) {
            if ((i & 1) == 0) {
                oddm++;
            }
        }

        // 每一个奇数都可以和偶数想匹配
        // 而在rows中剩余偶数的个数为m-oddr，在cols中剩余奇数的个数为n-oddm
        return (oddr * oddm) + (m - oddr) * (n - oddm);
    }
}