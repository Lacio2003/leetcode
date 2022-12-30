/**
 * 1)先对数组进行排序(nlogn)
 * 2)判断0 的边界O(n) 如果等于最后一个位置，则结束
 * 3)每次找出最小的正整数O(1)
 * 4)让所有的非零数减去这个数字O(n)
 * 5)一直循环2~4，直到循环退出

 * 时间复杂度:O(nlogn + n)
 * 空间复杂度:O(n)
 */
class Solution {
    public int minimumOperations(int[] nums) {
        // 对数组进行排序
        Arrays.sort(nums);

        // 计算循环的次数
        int ans = 0;
        // 0的边界
        int bound = foundBound(nums, -1);
        // 为了方便使用，将nums.length存储到变量当中
        int n = nums.length;
        // 按照题目要求，对数组中的要求进行操作
        while (bound + 1 < n) {
            // 获取数组当中的最小非零元素
            int minInteger = nums[bound + 1];
            // 对数组中所有的元素减去最小minInteger
            reduceNums(nums, minInteger, bound + 1);
            // 更新循环次数
            ans++;
            // 更新边界
            bound = foundBound(nums, bound);
        }

        return ans;
    }

    /**
     * 在nums当中寻找0的边界
     * @param bound 0边界
     * @return 返回数组当中0的边界
     */
    private int foundBound(int[] nums, int bound) {
        while (bound + 1 < nums.length && nums[bound + 1] == 0) {
            bound++;
        }
        return bound;
    }

    /**
     * 对nums当中的所有的非零元素减去minInteger
     * @param minInteger 最小非零整数
     * @param begin 非零元素开始的位置
     */
    private void reduceNums(int[] nums, int minInteger, int begin) {
        for (int i = begin; i < nums.length; i++) {
            nums[i] -= minInteger;
            // 如果等于负数，直接赋值0即可。
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }
    }
}