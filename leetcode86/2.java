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
    准备两个链表，一个是small，一个是large，small存储小于x的结点，large存储大于等于x的结点，最后让small指向large的头节点即可
*/
class Solution {
    public ListNode partition(ListNode head, int x) {
        // 准备指针
        ListNode smallHead = new ListNode(), small = smallHead;
        ListNode largeHead = new ListNode(), large = largeHead;

        // 开始遍历
        for (ListNode p = head; p != null; p = p.next) {
            if (p.val < x) {
                small.next = p;
                small = small.next;
            } else {
                large.next = p;
                large = large.next;
            }
        }

        // 拼接链表
        large.next = null;
        small.next = largeHead.next;

        return smallHead.next;
    }
}