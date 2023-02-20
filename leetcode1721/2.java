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
    交换两个节点
    三个特殊情况:
        两个节点是挨着的。
        两个节点重合

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        // 排除特殊情况
        if (null == head || null == head.next) {
            return head;
        }
        // 添加哑结点
        ListNode dummy = new ListNode();
        dummy.next = head;

        // 获取链表的长度
        int count = 0;
        for (ListNode p = dummy; null != p; p = p.next) {
            count++;
        }

        // 找到两个节点
        // 找到第一个节点
        ListNode preFirst = dummy;
        for (int i = 0; i < k - 1; i++) {
            preFirst = preFirst.next;
        }
        // 找到第二个节点
        ListNode preSecond = dummy;
        for (int i = 0; i < count - k - 1; i++) {
            preSecond = preSecond.next;
        }
        ListNode first = preFirst.next, second = preSecond.next;

        // 进行节点的交换
        if (first.next == second) {
            // 两个节点是挨着的
            preFirst.next = second;
            first.next = second.next;
            second.next = first;
        } else if (second.next == first) {
            preSecond.next = first;
            second.next = first.next;
            first.next = second;
        } else {
            // 一般的交换，两个节点不是挨着的
            preFirst.next = first.next;
            preSecond.next = second.next;
            second.next = preFirst.next;
            preFirst.next = second;
            if (first != second) {
                first.next = preSecond.next;
                preSecond.next = first;
            }
        }
        return dummy.next;
    }
}