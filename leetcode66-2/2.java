/**
 * 思路：根据题意可得，让我们求的时每一个字符在每一天当中出现的最大次数。
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * note:使用HashMap一样可以解决这个问题，
 * 但是在Java中HashMap的遍历太过复杂。所以，没有使用
 */
class Solution {
    public int minNumBooths(String[] demand) {
        // 总频数数组
        int[] total = new int[26];

        for (int i = 0; i < demand.length; i++) {
            // 记录当天每一个字符出现的次数
            int[] single = new int[26];
            for (char c : demand[i].toCharArray()) {
                single[c - 'a']++;
            }

            // 对总频数数组进行更新
            for (int j = 0; j < 26; j++) {
                total[j] = Math.max(total[j], single[j]);
            }
        }

        // 计算频数数组的和
        int ans = 0;
        for (int e : total) {
            ans += e;
        }

        // 返回频数数组的和
        return ans;
    }
}