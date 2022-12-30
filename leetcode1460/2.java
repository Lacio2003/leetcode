/**
 * 思路：由题意可得：两个数组中的元素如果完全一样的话，arr一定可以转化为target，所以，只需要检查两个数组中的元素是否是一样的。
 * 使用哈希表，现将一个数组当中的元素存储到哈希表当中，然后遍历另一个数组进行检验。需要注意：有可能同一个数字存在多次的问题。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        // 存储元素的哈希表
        int[] hash = new int[1001];

        // 将target中的元素存储到一个哈希表当中
        for (int e : target) {
            hash[e]++;
        }

        for (int e : arr) {
            // 如果arr的元素，哈希表不存在，说明两个数组不相等
            if (hash[e] == 0) {
                return false;
            }
            // 存在一个元素重复存在的现象，所以需要进行减减操作
            hash[e]--;
        }

        return true;
    }
}