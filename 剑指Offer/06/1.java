/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
    思路:
        1.获取链表的长度，并新建一个同样长度的数组
        2.遍历链表，将结点的值倒着插入数组
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int[] reversePrint(ListNode head) {
        // 链表为空，直接返回
        if (null == head) {
            return new int[]{};
        }
        // 1.获取链表的长度
        int length = 0;
        for (ListNode p = head; null != p; p = p.next) {
            length++;
        }

        // 创建数组
        int[] ans = new int[length];

        // 2.遍历链表，倒着插入数组当中
        ListNode p = head;
        for (int i = length - 1; null != p && i > -1; i--, p = p.next) {
            ans[i] = p.val;
        }

        return ans;
    }
}