/**
 * 思路：可以直接遍历stones，判断当前字符是不是宝石。
 * 1.可以将jewels中的字符存储在哈希表当中。
 * 2.遍历stones，判断每一个字符是不是在哈希表当中
 * 
 * 时间复杂度：O(m+n)
 * 空间复杂度：O(m)
 */
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // jewels中的哈希表
        Set<Character> hashJewels = conversion(jewels);

        // 统计stones中宝石的数量
        int count = 0;
        for (char c : stones.toCharArray()) {
            // 该石头是宝石,count++
            if (hashJewels.contains(c)) {
                count++;
            }
        }

        return count;
    }

    /**
     * 将jewels中的字符读取到一个哈希表当中
     * @param jewels 要读取的字符
     * @return jewels中的哈希表
     */
    private Set<Character> conversion(String jewels) {
        // 存储jewels中每一个字符的哈希表
        Set<Character> hashJewels = new HashSet<>();
        // 遍历jewels，取出每一个字符
        for (char c : jewels.toCharArray()) {
            hashJewels.add(c);
        }
        return hashJewels;
    }
}