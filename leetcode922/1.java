/*
    准备一个数组，然后将原来的数组的奇数放在新数组的奇数的位置上，原来的偶数放在偶数的位置上

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        // 准备一个数组
        int n = nums.length;
        int[] ans = new int[n];

        // 遍历nums
        // 找到奇数
        int i = 1;
        for (int e : nums) {
            if ((e & 1) == 1) {
                ans[i] = e;
                i+= 2;
            }
        }

        // 找到偶数
        i = 0;
        for (int e : nums) {
            if ((e & 1) == 0) {
                ans[i] = e;
                i+= 2;
            }
        }

        return ans;
    }
}