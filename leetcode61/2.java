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
        1.排除不合法的情况:null == head || null == head.next
        2.获取链表的长度n并记录最后一个节点
        3.将链表结成环
        4.计算要断开连接的地方(n-1)-(k%n)，下标从0开始
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // 1.排除不合法的情况
        if (null == head || null == head.next) {
            return head;
        }

        // 2.获取链表的长度n
        ListNode p = head;
        int n = 1;
        while (null != p.next) {
            p = p.next;
            n++;
        }

        // 3.将链表结成环
        p.next = head;

        // 4.在合适的地方断开连接
        ListNode breakNode = head;
        for (int i = 0; i < ((n - 1) - k % n); i++) {
            breakNode = breakNode.next;
        }

        // 记录新的头节点
        ListNode newHead = breakNode.next;
        breakNode.next = null;

        return newHead;
    }
}