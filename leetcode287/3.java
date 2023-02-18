/*
    快慢指针。
    根据题目中的数组的特性，将数组看成一个链表，如果有重复的数字，那么一定会会有环。只要找到环扣就可以了。

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int findDuplicate(int[] nums) {
        // 快慢指针开始走
        int slow = 0, fast = 0;
        slow = nums[slow];
        // 快指针先走两步
        fast = nums[nums[fast]];

        while (fast < nums.length && fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        // 一个指针从头开始走
        int p1 = 0, p2 = slow;
        while (p1 != p2) {
            p1 = nums[p1];
            p2 = nums[p2];
        }

        return p1;
    }
}