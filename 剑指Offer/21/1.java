/*
    新建一个数组，遍历两次
    第一次将所有的奇数放在新数组里面
    第二次将所有的偶数放在新数组里面

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int[] exchange(int[] nums) {
        // 新建数组
        int n = nums.length;
        int[] ans = new int[n];

        // 第一次遍历，将所有的奇数拿出来
        int index = 0;
        for (int e : nums) {
            if ((e & 1) == 1) {
                ans[index++] = e;
            }
        }

        // 第二次遍历，将所有的偶数拿出来
        for (int e : nums) {
            if ((e & 1) == 0) {
                ans[index++] = e;
            }
        }

        return ans;
    }
}