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
    思路：
        1.为了方便处理，设置一个虚拟的头节点
        2.找到要删除的链表的头部的前一个结点
        3.使用头插法将后面的指定的结点重新插入到当前结点的后面
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 1.设置虚拟的头节点
        ListNode dummy = new ListNode();
        dummy.next = head;
        head = dummy;

        // 2.找到要删除的链表的头部的前一个结点
        ListNode pre = head, curNode = head.next;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
            curNode = curNode.next;
        }

        // 3.使用头插法将后面的指定的结点重新插入到当前结点的后面
        for (int i = 0; i < right - left; i++) {
            // 把下一个结点删除
            ListNode remove = curNode.next;
            curNode.next = remove.next;

            // 把当前结点插入pre后面
            remove.next = pre.next;
            pre.next = remove;
        }

        return head.next;
    }
}