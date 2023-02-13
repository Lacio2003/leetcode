/*
    根据前一个格子的数量来计算当前格子的数量。
    根据题意我们可以发现:i+1格子的移动次数=i-i格子的一定次数+i格子左边的1个数-i格子右边的1的个数

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int[] minOperations(String boxes) {
        // 假设从boxes的0的位置开始，先计算lc(左边1的个数)和rc右边1的个数
        char[] chars = boxes.toCharArray();
        int lc = (chars[0] == '1' ? 1 : 0), rc = 0;
        int n = chars.length;
        int[] ans = new int[n];
        for (int i = 1; i < n; i++) {
            if (chars[i] == '1') {
                ans[0] += i;
                rc++;
            }
        }

        // 遍历计算每一个格子的数量
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + lc - rc;

            if (chars[i] == '1') {
                lc++;
                rc--;
            }
        }

        return ans;
    }
}