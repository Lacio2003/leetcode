// 使用分治思想解决这个问题。
class Solution {
    /**
     * 使用分治思想来解决这个问题。
     * @param l 分治的行的左边界。
     * @param r 分治行的的右边界。
     * @param L 分治的列的左边界
     * @param R 分治的列的右边界
     * @param grid 分治的矩阵
     * @return 当前行中存在的负数的个数
     */
    private int solve(int l, int r, int L, int R, int[][] grid) {
        // 左边界超过右边界时停止
        if (l > r) {
            return 0;
        }

        // 取中间位置。
        int mid = l + ((r - l) >> 1),pos = -1;
        // 寻找中间列的负数的位置。
        for (int i = L; i <= R; i++) {
            if (grid[mid][i] < 0) {
                pos = i;
                break;
            }
        }

        // 记录当前行的负数的个数。
        int ans = 0;
        if (pos >= 0) {
            // pos大于0的时候，说明当前行存在负数。
            // 将当前行的负数的个数记录下来。
            ans += grid[0].length - pos;
            // 往左边分治。
            // 因为整个矩阵的行和列都是非递增的，那么上一行的负数一定在这一列负数的右边。反之，下一行的负数一定在这一行的负数的左边。
            /* 之所以传递的时候传递边界，是因为如果不传递pos而是pos+1或者pos-1，那么当遇到这一行的负数和上一行的负数的位置相同的时候，就会少算。所以，为了正确，需要传递pos。向下一行传递参数的过程，因为下一行第一位负数的位置一定在这一行的负数的位置的左边。所以，就算传递pos也没有关系。
            */
            ans += solve(l, mid - 1, pos, R, grid);
            ans += solve(mid + 1, r, L, pos, grid);
        } else {
            /* 
                当前行不存在负数。那么上一行没有必要分治。因为整个矩阵是行和列非递增的。
                当前行不存在负数，那么上一行一定没有负数。
            */
            ans += solve(mid + 1, r, L, R, grid);
        }

        return ans;
    }

    public int countNegatives(int[][] grid) {
        return solve(0, grid.length - 1, 0, grid[0].length - 1, grid);
    }
}