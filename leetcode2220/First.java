class Solution {
    public int minBitFlips(int start, int goal) {
        /*
         * 先求出两个数的异或结果，统计异或结果中1的位数，即为答案。
         */
        
        // 两个数异或的结果
        int num = start ^ goal;

        // 记录1的个数。
        int ans = 0;
        // 利用BrianKernighan算法，每次删去异或结果最右边的1
        while (num > 0) {
            ans++;
            num &= num - 1;
        }

        return ans;
    }
}