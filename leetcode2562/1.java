/*
    双指针，从两边向中间找
    主要解决如何将两个数字拼接在一起，利用其中一个数字的位数

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public long findTheArrayConcVal(int[] nums) {
        // 准备指针
        int n = nums.length;
        int left = 0, right = n - 1;

        // 开始遍历
        long ans = 0;
        while (left <= right) {
            // 只剩下一个数字的时候
            if (left == right) {
                ans += nums[left];
                return ans ;
            }
            
            // 至少剩下两个数字
            long res = concatTowNumber((long)nums[left], nums[right]);
            ans += res;
            left++;
            right--;
        }

        return ans;
    }

    private long concatTowNumber(long num1, int num2) {
        // 判断num2的位数
        int count = 0, copyNum = num2;
        while (copyNum != 0) {
            count++;
            copyNum /= 10;
        }
        // 对num1乘以num2的位数个的10
        for (int i = 0; i < count; i++) {
            num1 *= 10;
        }

        // 相加返回结果
        return num1 + num2;
    }
}