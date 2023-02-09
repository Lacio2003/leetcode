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
    找到链表的后半部分
    对链表的后半部分进行反转
    同时遍历两个链表，进行求和
    将后半部分翻回去

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int pairSum(ListNode head) {
        // 1.准备变量
        int ans = 0;
        ListNode preAfter = head;
        ListNode preList = head;


        // 2.获取链表的长度
        int len = length(head);
        // 3.找到链表的后半部分
        for (int i = 0; i < (len / 2) - 1; i++) {
            preAfter = preAfter.next;
        }
        // 4.反转后半部分
        ListNode after = reverse(preAfter.next);

        // 5.同时遍历两个链表，求答案
        ListNode pAfter = after;
        for (int i = 0; i < (len / 2); i++) {
            ans = Math.max(preList.val + after.val, ans);
            after = after.next;
            preList = preList.next;
        }

        // 6.将后半部分反转回去
        preAfter.next = reverse(pAfter);

        return ans;
    }

    private int length(ListNode head) {
        int count = 0;
        while (null != head) {
            count++;
            head = head.next;
        }

        return count;
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