/*
    使用两个容器，分别储存正整数和负整数
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int[] rearrangeArray(int[] nums) {
        // 分别储存正整数和负整数
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for (int e : nums) {
            if (e > 0) {
                positive.add(e);
            } else {
                negative.add(e);
            }
        }

        // 将数字全部取出来，放回原来的数组
        for (int i = 0, j = 0; j < positive.size(); i += 2, j++) {
            nums[i] = positive.get(j);
        }

        for (int i = 1, j = 0; j < negative.size(); i += 2, j++) {
            nums[i] = negative.get(j);
        }

        return nums;
    }
}