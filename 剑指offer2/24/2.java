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
* 递归的实现:使用一个prv代表上一个结点，同时保存倒转链表之后的头节点
* 每次递归过程中，先使用一个指针存储下一个结点，然后反转当前的链接
* 时间复杂度:O(n)
* 空间复杂度:O(n)
*/
class Solution {
    // 上一个结点
    ListNode pre = null;
    public ListNode reverseList(ListNode head) {
        // 递归结束条件
        if (null == head) {
            return pre;
        }

        // 保存下一个结点
        ListNode next = head.next;
        // 倒转链接
        head.next = pre;
        // 移动pre
        pre = head;
        return reverseList(next);
    }
}