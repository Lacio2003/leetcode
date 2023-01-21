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

/**
 * 思路:
 *   1.创建一个新的链表，并设置一个虚拟的头节点
 *   2.使用两个指针，一个指向list1，一个指向list2
 *   3.遍历两个链表，两个指针指向的结点哪一个小，链接那一个
 *   4.处理剩余没有链接的结点
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 1.创建一个新链表，为了方便操作，设置一个头节点
        // curNode指向新链表的当前节点
        ListNode newHead = new ListNode(), curNode = newHead;

        // 2.指向list1和list2的两个指针
        ListNode p1 = list1, p2 = list2;
        // 3.遍历两个链表，哪一个指针的结点的值小，链接哪一个
        while (null != p1 && null != p2) {
            if (p1.val < p2.val) {
                // p1的结点比p2的结点小或者相等
                curNode.next = p1;
                p1 = p1.next;
            } else {
                // p2的结点更小
                curNode.next = p2;
                p2 = p2.next;
            }
            curNode = curNode.next;
        }

        // 4.处理剩余没有链接的结点
        curNode.next = null == p1 ? p2 : p1;
        return newHead.next;
    }
}