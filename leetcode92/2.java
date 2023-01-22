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
    思路：
        1.为了方便处理，设置一个虚拟的头节点
        2.找到要反转的链表的前一个结点以及尾巴结点
        3.切断连接
        4.将要反转的部分反转
        5.将反转的链表接回去
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 1.设置虚拟节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        head = dummy;

        // 2.找到要反转的链表的前一个结点以及尾巴结点
        ListNode leftPointer = head, pre = head, rightPointer = head, succ = head;
        // 先找到要反转的链表的前驱结点
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        leftPointer = pre.next;

        rightPointer = leftPointer;
        // 找到反转链表的最后一个结点
        for (int i = 0; i < right - left; i++) {
            rightPointer = rightPointer.next;
        }
        succ = rightPointer.next;


        // 3.切断连接
        pre.next = null;
        rightPointer.next = null;


        // 4.反转链表
        reverseList(leftPointer);

        // 5.将反转之后的链表结回去
        pre.next = rightPointer;
        leftPointer.next = succ;
        
        return head.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (null != cur) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}