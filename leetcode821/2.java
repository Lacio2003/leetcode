/**
 * 思路：先寻找每一个位置到左边C的距离，然后在寻找到右边的距离进行比较。
 * 时间复杂度：O(n + n + n)，整体来说是O(n)
 * 空间复杂度：O(1)。不算返回答案的数组
 */
class Solution {
    public int[] shortestToChar(String s, char c) {
        // 为了方便使用，将字符串的长度存储到变量当中
        int n = s.length();
        // 答案数组
        int[] ans = new int[n];
        // 为了后面的填充，需要事先将ans填充为一个比s的长度大的值
        Arrays.fill(ans, n + 1);

        // 计算每个字符到左边c的距离
        for (int i = 0, j = -1; i < n; i++) {
            if (s.charAt(i) == c) {
                j = i;
            }
            if (j != -1) {
                ans[i] = i - j;
            }
        }

        // 计算每个字符到右边c的距离
        for (int i = n - 1, j = -1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                j = i;
            }
            // 这里需要和左边的距离比大小。
            if (j != -1 && j - i < ans[i]) {
                ans[i] = j - i;
            }
        }
        
        return ans;
    }
}