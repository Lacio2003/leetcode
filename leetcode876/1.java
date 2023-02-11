/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
    获取链表的长度，根据链表的长度来获取中间的结点
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public ListNode middleNode(ListNode head) {
        // 获取链表的长度
        int len = length(head);

        // 根据长度进行遍历
        ListNode ans = head;
        for (int i = 0; i < (len >> 1); i++) {
            ans = ans.next;
        }
        return ans;
    }

    private int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }
}