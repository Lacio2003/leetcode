/*
    使用双指针，i指向奇数的位置，j指向偶数的位置
    如果i指向的是一个偶数，那么j每次移动两个单位，寻找到奇数，然后和nums[i]交换。直到其中一个指针越界

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        // 准备两个变量
        int pEven = 0, pOdd = 1;

        // 遍历数组
        int n = nums.length;
        while (pEven < n &&  pOdd < n) {
            if ((nums[pEven] & 1) == 1) {
                while (pOdd < n && (nums[pOdd] & 1) != 0) {
                    pOdd += 2;
                }

                swap(nums, pEven, pOdd);
            }
            pEven += 2;
        }

        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] ^= nums[j];
            nums[j] ^= nums[i];
            nums[i] ^= nums[j];
        }
    }
}
