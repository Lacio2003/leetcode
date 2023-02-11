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
    由于直接使用迭代无法返回上一个结点，这个问题可以使用递归来解决。

    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public void reorderList(ListNode head) {
        change(head, head);
    }

    /**
     * headNext相等于左指针指向的结点
     * @param head rear相当于右指针指向的结点
     */
    private ListNode change(ListNode head, ListNode rear) {
        // basic case
        if (null == rear) {
            return head;
        }

        // 获取左边的结点
        ListNode headNext = change(head, rear.next);
        if (null == headNext) {
            return null;
        } else if (headNext == rear || headNext.next == rear) {
            // 说明已经来到了链表的最中间。
            rear.next = null;
            return null;
        }

        // 修改指针
        ListNode next = headNext.next;
        headNext.next = rear;
        rear.next = next;

        return next;
    }
}