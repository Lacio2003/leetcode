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
/**
 * 思路:新建一个链表头指针。然后遍历原来的链表，将原来的链表的结点使用头插法插入到新的
 * 链表当中。
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // 新的链表
        // 为了方便操作，建一个头节点。
        ListNode newNode = new ListNode();
        // 遍历head链表的指针
        ListNode cur = head;
        while (cur != null) {
            // 将原来链表的结点使用头插法插入到新的链表当中
            ListNode next = cur.next;
            cur.next = newNode.next;
            newNode.next = cur;
            // 移动指针
            cur = next;
        }

        return newNode.next;
    }
}