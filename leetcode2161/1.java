/*
    遍历三次，第一次找比pivot小的，第二次找等于，第三次找大于的。
    时间复杂度:O(n)
    空间夫再度:O(n)
*/
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        // 1.准备变量
        // nums的长度
        int n = nums.length;
        // 记录是否遍历过的状态数组
        boolean[] isTraversal = new boolean[n];
        // 存储答案的数组
        int[] ans = new int[n];
        // ans的指针
        int index = 0;

        // 2.第一次遍历
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                ans[index++] = nums[i];
                isTraversal[i] = true;
            }
        }
        // 3.第二次遍历
        for (int i = 0; i < n; i++) {
            if (!isTraversal[i] && nums[i] == pivot) {
                ans[index++] = nums[i];
                isTraversal[i] = true;
            }
        }
        // 4.第三次遍历
        for (int i = 0; i < n; i++) {
            if (!isTraversal[i] && nums[i] > pivot) {
                ans[index++] = nums[i];
                isTraversal[i] = true;
            }
        }
        return ans;
    }
}