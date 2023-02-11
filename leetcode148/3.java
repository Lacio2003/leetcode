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
    归并排序递归版本
    时间复杂度:O(nlogn)
    空间复杂度:O(logn)
*/
class Solution {
    public ListNode sortList(ListNode head) {
        // 排除不合法的情况
        if (null == head || null == head.next) {
            return head;
        }

        // 找到中点，然后切割成两部分
        ListNode fast = head, slow = head;
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 对两部分分别进行排序
        // 将两部分切断
        ListNode after = slow.next;
        slow.next = null;
        // 递归这两部分
        ListNode left = sortList(head);
        ListNode right = sortList(after);

        // 将两部分接到一起
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (null != left && null != right) {
            if (left.val <= right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }

            p = p.next;
        }

        // 连接剩余的部分
        p.next = null != left ? left : right;

        return dummy.next;
    }
}