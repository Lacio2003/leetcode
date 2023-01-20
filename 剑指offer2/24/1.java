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
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // prev是上一个结点
        // cur是当前结点
        ListNode prev = null, cur = head;
        while (null != cur) {
            // next是当前结点的下一个结点
            ListNode next = cur.next;
            // 反转链接
            cur.next = prev;
            // 移动指针
            prev = cur;
            cur = next;
        }

        return prev;
    }
}