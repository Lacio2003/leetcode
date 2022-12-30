class Solution {
    public int smallestEqual(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 判断当前下标是否符合下标
            if (i % 10 == nums[i]) {
                return i;
            }
        }

        // 存在符合条件的下标
        return -1;
    }
}