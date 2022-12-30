/**
 * 思路：按照题目要求，直接对数组进行遍历。计算折扣后的价格即可。
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 */
class Solution {
    public int[] finalPrices(int[] prices) {
        // 为了方便使用，将prices的长度存储到变量当中
        int n = prices.length;
        // 存储答案的数组
        int[] ans = new int[n];
        // 填充ans数组
        for (int i = 0; i < n; i++) {
            ans[i] = prices[i] - findDiscount(prices, i);
        }

        return ans;
    }

    /**
     * 寻找符合条件的j
     * @return 符合条件的j下标里面的值，如果不存在返回0
     */
    private int findDiscount(int[] prices, int curr) {
        for (int i = curr + 1; i < prices.length; i++) {
            if (prices[i] <= prices[curr]) {
                return prices[i];
            }
        }

        return 0;
    }
}