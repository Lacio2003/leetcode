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
        2.遍历两个链表，进行相加。并准备一个carry变量，来记录是否进位
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
        // carry记录是否进位
        int carry = 0;

        while (null != p1 || null != p2 || 0 != carry) {
            // 求出当前节点的和
            int sum = carry;
            if (null != p1) {
                sum += p1.val;
                p1 = p1.next;
            }
            if (null != p2) {
                sum += p2.val;
                p2 = p2.next;
            }

            // 创建新的节点
            pNew.next = new ListNode(sum % 10);
            carry = sum / 10;
            pNew = pNew.next;
        }

        return newHead.next;
    }
}