/**
 * 思路：反向思路，存储orginal的2的倍数值。然后遍历nums。将存在的倍数值的value修改成2。然后不断让oringal乘以2。检查对应的value值是不是2。如果不是就停止。返回orginal。
 * 时间复杂度：O(n + log(C/orginal)
 * 空间复杂度：O(logC)
 */
class Solution {
    public int findFinalValue(int[] nums, int original) {
        // 存储orginal的2的倍数的哈希表
        Map<Integer, Integer> hash = new HashMap<>();
        for (int i = original; i <= 1000; i <<= 1) {
            hash.put(i, 1);
        }

        // 遍历nums，将存在的值的value修改为2
        for (int e : nums) {
            if (hash.containsKey(e)) {
                hash.put(e, 2);
            }
        }

        // 不断递增orginal，检查value是否是2
        while (hash.containsKey(original) && hash.get(original) == 2) {
            original <<= 1;
        }

        return original;
    }
}