/**
 * 思路：暴力破解，直接在stones中寻找jewels中字符的数量
 * 时间复杂度：O(mn)
 * 空间复杂度：O(1)
 */
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // 统计stones宝石的数量
        int count = 0;
        // 暴力破解，使用双重for循环
        for (char jewel : jewels.toCharArray()) {
            for (char stone : stones.toCharArray()) {
                if (jewel == stone) {
                    count++;
                }
            }
        }
        return count;
    }
}