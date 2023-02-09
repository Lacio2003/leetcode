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
    使用前插法，复制链表的后半部分。
    然后同时遍历两个链表，进行相加
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int pairSum(ListNode head) {
        // 1.准备变量
        // 链表的前半部分
        ListNode afterList = new ListNode(0);
        // 后半部分的指针
        ListNode after = head;
        // 原来链表的指针
        ListNode preList = head;
        // 最后结果的变量
        int ans = 0;

        // 2.获取链表的长度
        int len = length(head);

        // 3.找到链表的后半部分
        for (int i = 0; i < (len / 2); i++) {
            after = after.next;
        }

        // 4.使用前插法重新构造链表的部分
        while (null != after) {
            // 保存下一个结点的指针
            ListNode next = after.next;
            after.next = afterList.next;
            afterList.next = after;
            after = next;
        }

        // 5.同时遍历两个链表，计算最后结果
        after = afterList.next;
        for (int i = 0; i < (len / 2); i++) {
            ans = Math.max(ans, after.val + preList.val);
            after = after.next;
            preList = preList.next;
        }

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
}