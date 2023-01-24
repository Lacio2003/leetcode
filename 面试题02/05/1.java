/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
    思路:
        1.新建一个链表来存放相加的结果
        2.遍历两个链表，进行相加。并准备一个carryb变量，来记录是否进位
        3.遍历没有遍历完成的链表，并检查是否carry是否是0，来进行进位的问题
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 新建一个链表来存放相加的结果
        ListNode newHead =  new ListNode(0);
        // p1指向l1，p2指向l2, pNew指向newHead。
        ListNode p1 = l1, p2 = l2, pNew = newHead;
        // carray记录是否进位
        int carry = 0;

        while (null != p1 && null != p2) {
            // 求和
            int sum = p1.val + p2.val + carry;
            // 新建一个节点
            pNew.next = new ListNode(sum % 10);
            // 判断是否进位
            carry = sum / 10;

            // 移动指针
            p1 = p1.next;
            p2 = p2.next;
            pNew = pNew.next;
        }

        // 遍历没有完成的链表
        while (null != p1) {
            int sum = p1.val + carry;
            pNew.next = new ListNode(sum % 10);
            carry = sum / 10;

            p1 = p1.next;
            pNew = pNew.next;
        }

        while (null != p2) {
            int sum = p2.val + carry;
            pNew.next = new ListNode(sum % 10);
            carry = sum / 10;

            p2 = p2.next;
            pNew = pNew.next;
        }

        if (1 == carry) {
        // 最后有进位，所以要创建一个新的节点
            pNew.next = new ListNode(carry);
        }

        return newHead.next;
    }
}