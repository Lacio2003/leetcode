/*
    简单的做法，使用哈希表存储数字，并检查是否由重复的

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int findDuplicate(int[] nums) {
        // 准备变量
        Set<Integer> hash = new HashSet<>();

        // 开始遍历
        for (int e : nums) {
            if (hash.contains(e)) {
                return e;
            }
            hash.add(e);
        }

        return 0;
    }
}