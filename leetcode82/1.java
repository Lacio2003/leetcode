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
 * 思路:
 *   1.为了方便处理，设置一个哑节点dummy
 *   2.使用一个cur指针遍历链表，比较下一个节点和下下一个节点值是否相同，
 *   3.如果相同，记录节点的下一个节点的值x，开始遍历链表，依次删除节点值为x的节点。
 *   4.如果不相同，直接移动cur指针。
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 1.设置一个哑节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        head = dummy;

        // 2.使用一个cur指针遍历链表，并判断下一个节点和下下一个节点的值是否相等
        ListNode cur = head;
        while (null != cur.next && null != cur.next.next) {
            // 可以进入循环，说明链表中至少有两个节点
            if (cur.next.val == cur.next.next.val) {
                // 3.下一个节点的值和下下一个节点的值相等，那么记录节点的值，并依次删除
                int x = cur.next.val;
                // 删除所有等于x的节点
                ListNode p = cur.next;
                while (null != p && p.val == x) {
                    p = p.next;
                }
                cur.next = p;
            } else {
                // 4.下一个节点和下下一个节点的值不相等，直接移动指针
                cur = cur.next;
            }
        }

        return head.next;
    }
}