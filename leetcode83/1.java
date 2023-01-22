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
 *   1.准备两个指针，一个是slow，一个是fast。
 *   2.遍历链表，如果slow和fast指向的节点的值相等，那么fast移动。slow不动。直到fast和slow的值不相等为止
 *   3.如果两个不相等，将fast的节点链接到slow指向的节点，slow往后移动一个节点。
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 1.两个指针，一个是slow，一个是fast
        ListNode slow = head, fast = head;

        while (null != fast) {
            // 2.slow和fast相等，fast移动，slow不动
            while (null != fast && fast.val == slow.val) {
                fast = fast.next;
            }

            // 3.fast和slow不相等，将fast链接到slow上面并让slow移动
            slow.next = fast;
            slow = slow.next;
        }

        return head;
    }
}