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
    先找到链表的后半部分
    然后将后半部分断开并反转
    再将后半部分插入到前半部分里面

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public void reorderList(ListNode head) {
        // 先找到链表的后半部分
        ListNode fast = head, slow = head;
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
        }


        // 反转链表的后半部分
        ListNode revHead = reverse(slow.next);
        // 将后半部分断开
        slow.next = null;

        // 将后半部分插入到前半部分里面
        ListNode newHead = new ListNode(0), tail = newHead;
        ListNode pFirst = head, pSecond = revHead;
        while (null != pFirst && null != pSecond) {
            tail.next = pFirst;
            // 这里pFirst一定要先移动，不然会发生错误
            pFirst = pFirst.next;
            tail = tail.next;

            tail.next = pSecond;
            pSecond = pSecond.next;

            tail = tail.next;
        }

        // 链接剩余的部分
        tail.next = null != pFirst ? pFirst : pSecond;

        head = newHead.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (null != cur) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}