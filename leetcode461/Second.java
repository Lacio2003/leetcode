class Solution {
    public int hammingDistance(int x, int y) {

        /*
         * 思路：根据Brian Kernighan算法(详见笔记或leetcode题解)，我们让两个异或的结果不断&自身-1。
         * 并记录次数。那么记录的次数就是答案。
         */

        // num两个数异或的结果。
        int num = x ^ y, ans = 0;
        while (num > 0) {
            // 根据BrianKernighan算法，不断去掉最右边的1.
            num &= (num - 1);
            // 记录次数。
            ans++;
        }
        return ans;
    }
}