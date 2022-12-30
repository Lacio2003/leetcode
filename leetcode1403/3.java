/**
 * 思路：依然使用贪心算法的思想。不过使用频数数组来代替排序。从而降低时间复杂度。
 * 时间复杂度：O(n)
 * 空间复杂度：O(C)
 */
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        // 构建频数数组，并计算和。
        int sum = 0;
        int[] frequent = new int[101];
        for (int num : nums) {
            frequent[num]++;
            sum += num;
        }

        // 存储最后答案的集合
        List<Integer> ans = new ArrayList<>();
        // 遍历寻找符合条件的序列
        int curr = 0, i = 100;
        while (curr <= sum) {
            if (frequent[i] != 0) {
                ans.add(i);
                curr += i;
                sum -= i;
                // 由于数组当中存在重复的数字。所以得进行--操作
                frequent[i]--;
            } else {
                // 里面的值为0的时候才进行减减。
                i--;
            }
        }
        
        return ans;
    }
}