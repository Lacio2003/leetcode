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
 *   1.递归的参数:一个参数就可以
 *   2.递归的返回值:ListNode
 *   3.递归的流程:当前节点和下一个结点相同的时候，表示这个结点要删除，返回需要找下一个不重复的结点，返回那一个结点，如果不相同，表示当前结点不用删除，进入下一个递归，返回当前结点
 * 时间复杂度:O(n) 
 * 空间复杂度:O(n)
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 递归的结束条件
        if (null == head || null == head.next) {
            return head;
        }

        if (head.val == head.next.val) {
            // 寻找下一个不相等的结点
            ListNode move = head;
            while (null != move && move.val == head.val) {
                move = move.next;
            }

            return deleteDuplicates(move);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }
}