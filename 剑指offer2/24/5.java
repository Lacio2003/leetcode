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
* 前插法的递归实现
* 时间复杂度:O(n)
* 空间复杂度:O(n)
*/
class Solution {
    // 新的链表
    ListNode newNode = new ListNode();
    public ListNode reverseList(ListNode head) {
        // 递归结束的条件
        if (null == head) {
            return newNode.next;
        }

        // 保存下一个结点的位置
        ListNode next = head.next;

        // 将当前结点插入到新的链表当中
        head.next = newNode.next;
        newNode.next = head;

        return reverseList(next);
    }
}