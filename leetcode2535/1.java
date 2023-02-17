/*
    先计算elementSum
    再计算digitSum
    最后做差即可

    时间复杂度:O(len)数组当中的所有数字的位数和
    空间复杂度:O(1)
*/
class Solution {
    public int differenceOfSum(int[] nums) {
        // 计算elementSum和digitSum
        int elementSum = 0, digitSum = 0;
        for (int e : nums) {
            elementSum += e;
            digitSum += digitSum(e);
        }

        return Math.abs(elementSum - digitSum);
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