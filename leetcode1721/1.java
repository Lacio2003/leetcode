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

    先获取数组的长度，根据长度来寻找指定的节点
    

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        // 获取链表的长度
        int count = 0;
        for (ListNode p = head; null != p; p = p.next) {
            count++;
        }
        // 根据长度获取指定的节点
        // 获取正数的节点
        ListNode headNode = head;
        for (int i = 0; i < k - 1; i++) {
            headNode = headNode.next;
        }
        // 获取倒数的节点
        ListNode tail = head;
        for (int i = 0; i < count - k; i++) {
            tail = tail.next;
        }

        // 交换两个节点的值
        int temp = headNode.val;
        headNode.val = tail.val;
        tail.val = temp;

        return head;
    }
}