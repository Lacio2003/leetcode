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
 * 递归的另一种写法
*/
class Solution {
    public ListNode reverseList(ListNode head) {
        // 递归的结束条件
        if (null == head || null == head.next) {
            return head;
        }

        ListNode newNode = reverseList(head.next);
        // 反转链接
        head.next.next = head;
        // 这一行代码必须写，因为不写，头节点和头节点的下一个节点会形成环
        head.next = null;
        return newNode;
    }
}