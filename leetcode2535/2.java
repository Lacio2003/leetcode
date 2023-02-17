/*
    因为elementSum >= digitSum，所以可以直接进行做差。这样可以因为数字过大数字溢出的问题。

    时间复杂度:O(len)数组当中的所有数字的位数和
    空间复杂度:O(1)
*/
class Solution {
    public int differenceOfSum(int[] nums) {
        int ans = 0;
        for (int e : nums) {
            ans += e - digitSum(e);
        }

        return ans;
    }

    private int digitSum(int num) {
        int ans = 0;
        while (num > 0) {
            ans += num % 10;
            num /= 10;
        }

        return ans;
    }
}