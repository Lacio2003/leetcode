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
 * 思路：递归实现
 *   1.递归参数:一个ListNode即可
 *   2.递归的返回值:ListNode
 *   3.递归的流程，如果下一个节点的值和当前节点的值相等，那么链接下下一个节点，下一次递归的参数还是head，
 *     如果不相等，下一次递归的参数就是head.next
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 递归的结束条件
        if (null == head || null == head.next) {
            return head;
        }

        // 下一次递归的节点
        ListNode next = head.next;
        if (head.next.val == head.val) {
            // 下一个节点的值和当前节点值相等，链接下下一个节点
            head.next = head.next.next;
            // 下一次递归的节点不改变
            next = head;
        }

        deleteDuplicates(next);
        return head;
    }
}