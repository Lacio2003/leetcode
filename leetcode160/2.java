/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * 思路:
 *  1.使用两个指针，p1指向headA，p2指向headB
 *  2.两个指针同时遍历自己的链表，如果，p1走到尽头，开始从headB走，p2走到尽头，开始从headA走。
 *  3.如果两个如果最后两个指针可以相遇，那么说明相交，并且相遇的地方就是相交的节点
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 1.两个指针，p1指向headA, p2指向headB
        ListNode p1 = headA, p2 = headB;

        // 2.两个指针同时遍历自己的链表，如果，p1走到尽头，开始从headB走，p2走到尽头，开始从headA走。
        while (p1 != p2) {
            p1 = null == p1 ? headB : p1.next;
            p2 = null == p2 ? headA : p2.next;
        }

        //3.如果两个如果最后两个指针可以相遇，那么说明相交，并且相遇的地方就是相交的节点
        return p1;
    }
}