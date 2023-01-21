/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 递归解决:
 *   1.递归的参数，ListNode和val就可以了。
 *   2.递归的结束条件，链表为空或者当前结点的值如果和val相等就停止
 *   3.递归的过程，如果当前结点的值和val相等，则返回当前结点的下一个结点，否则，返回当前结点
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 */
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        // 递归结束条件
        if (null == head) {
            return null;
        }else if (head.val == val) {
            return head.next;
        }

        // 程序可以执行到这里，说明被删除的一定不是首结点，所以不会发生问题
        head.next = deleteNode(head.next, val);
        return head;
    }
}