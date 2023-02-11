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
    准备两个指针，一个是fast指针，一个是slow，fast一次走两步，slow一次走一步。
    时间复杂度:O(n)
    空间复杂度:O(1)

*/
class Solution {
    public ListNode middleNode(ListNode head) {
        // 准备指针
        ListNode fast = head, slow = head;

        // 开始遍历
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 如果链表的个数是奇数，那么fast会走到最后一个结点
        // 如果链表的个数是偶数，那么fast会走到倒数第二个结点
        return null != fast.next ? slow.next : slow;
    }
}