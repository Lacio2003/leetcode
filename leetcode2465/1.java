/*
    找到最大值和最小值问题
        排序解决
    计算平均值问题 
        双指针得到
    记录不重复的平均值问题
        哈希表解决

    思路:
        先排序，然后使用双指针，将每一次得到的结果存储到一个哈希表当中。

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int distinctAverages(int[] nums) {
        // 排序
        Arrays.sort(nums);

        // 计算平均值并进行记录
        int n = nums.length;
        int left = 0, right = n - 1;
        Set<Double> hash = new HashSet<>();

        while (left < right) {
            hash.add((nums[left] + nums[right]) / 2.0);
            left++;
            right--;
        }

        return hash.size();
    }
}