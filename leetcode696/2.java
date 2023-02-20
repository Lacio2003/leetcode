/*
    website:https://leetcode.cn/problems/count-binary-substrings/solutions/367704/ji-shu-er-jin-zhi-zi-chuan-by-leetcode-solution/
    将s中1的数量和0的数量放到对应的数组里面，然后进行统计。

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int countBinarySubstrings(String s) {
        // 将数量放到list集合当中
        List<Integer> nums = new ArrayList<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n;) {
            char c = chars[i];
            int count = 0;
            while (i < n && chars[i] == c) {
                count++;
                i++;
            }

            nums.add(count);
        }

        // 统计数量
        int size = nums.size(), ans = 0;
        for (int i = 1; i < size; i++) {
            ans += Math.min(nums.get(i - 1), nums.get(i));
        }
        return ans;
    }
}