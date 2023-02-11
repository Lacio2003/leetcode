/*
    使用双指针。
    准备一个指针bound用来表示奇数的边界，另一个指针p遍历。
    如果p指向的是一个奇数，那么和bound+1的位置的数字进行交换，bound++，如果是偶数直接跳过。

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int[] exchange(int[] nums) {
        // 准备指针
        int bound = -1, p = 0;

        // 开始遍历
        while (p < nums.length) {
            if ((nums[p] & 1) == 1) {
                int temp = nums[bound + 1];
                nums[bound + 1] = nums[p];
                nums[p] = temp;

                bound++;
            }
            p++;
        }

        return nums;
    }
}