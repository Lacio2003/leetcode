/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
    思路:递归解决
        1.递归的参数:一个ListNode
        2.递归的结束条件:head为空的时候，并在这个时候新建一个数组
        3.递归的流程:先利用递归统计链表的长度，然后再递归返回的过程中，对数组进行赋值
    时间复杂度:O(n)
    空间复杂度:O(n)
*/ 
class Solution {
    // 答案数组
    int[] ans = {};
    // 统计结点的个数
    int count = 0;
    public int[] reversePrint(ListNode head) {
        if (null == head) {
            // 新建数组
            ans = new int[count];
            return ans;
        }

        count++;
        reversePrint(head.next);

        // 对数组进行赋值
        ans[ans.length - count] = head.val;
        count--;
        return ans;
    }
}