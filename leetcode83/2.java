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
 *   1.遍历链表，如果链表下一个节点的值和当前节点的值相等，那么将下下一个的节点链接到当前节点
 *   2.如果不相等，指针直接移动。
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (null != cur && null != cur.next) {
            if (cur.val == cur.next.val) {
                // 下一个节点的值和当前节点的值相等，链接下下一个节点
                cur.next = cur.next.next;
            } else {
                // 下一个节点的和当前节点的值不相等，直接链接
                cur = cur.next;
            }
        }

        return head;
    }
}