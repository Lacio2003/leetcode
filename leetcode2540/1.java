/*
    将nums1的所有的元素加入到哈希表当中，然后遍历nums2，查看当前元素是否在哈希表当中出现过

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // 将nums1的元素放入哈希表
        Set<Integer> hash = new HashSet<>();
        for (int e : nums1) {
            hash.add(e);
        }

        // 遍历num2，并检查是否在哈希表当中出现过
        for (int e : nums2) {
            if (hash.contains(e)) {
                return e;
            }
        }

        return -1;
    }
}