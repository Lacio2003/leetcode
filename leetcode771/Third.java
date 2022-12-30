/**
 *思路：使用一个字符频率表，记录jewels中出现的字符的频率，然后遍历stones中的字符，
 *如果这个字符出现在频率数组当中。进行加1，最后返回和。
 *时间复杂度：O(n)
 *空间复杂度：O(1)
 */

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // 记录字符的频数数组
        int[] freq = new int[58];

        // 遍历jewels中出现的字符
        for (char jewel : jewels.toCharArray()) {
            freq[jewel - 'A']++;
        }

        // 遍历stones，记录宝石的数量
        int count = 0;
        for (char stone : stones.toCharArray()) {
            // 当前这个石头是宝石
            if (freq[stone - 'A'] > 0) {
                count++;
            }
        }

        return count;
    }
}