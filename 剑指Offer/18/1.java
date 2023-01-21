/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 思路：
 *   1.在链表的前面加上一个头节点
 *   2.寻找到指定的节点的前一个结点
 *   3.实行节点的删除，让指定节点的前一个结点的指针指向指定结点的下一个结点，释放指定节点的空间
 *   note:指定删除的结点可能是头节点，为了方便操作，在所有的链表的前面加上一个头节点
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        // 1.在链表的前面加上一个头节点
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        head = newHead;

        // 2.寻找到指定结点的前一个结点
        ListNode pre = head;
        while (pre.next.val != val) {
            pre = pre.next;
        }

        // 3.施行结点的删除
        pre.next = pre.next.next;

        return head.next;
    }
}