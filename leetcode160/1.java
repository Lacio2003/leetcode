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
 *  1.先遍历headA记录headA的最后一个节点，并记录长度。
 *  2.再遍历headB记录headB的最后一个节点，并记录长度
 *  3.比较headA和headB的最后一个节点的内存地址是不是相等，不相等说明两个链表不相交，直接返回null，
 *  4.如果第三步的比较为相等，使用两个指针分别指向两个链表，快的指针先走`长的链表的长度-短的链表的长度`。然后两个指针一起走，最后两个指针重合的地方就是相交的地方。
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 排除不合法的情况
        if (null == headA || null == headB) {
            return null;
        }

        ListNode endA = headA, endB = headB;

        // 1.记录headA和headB最后一个节点，并记录长度
        // 这个只使用一个count变量，记录了两个链表长度的差值
        int count = 0;
        while (null != endA.next) {
            count++;
            endA = endA.next;
        }
        while (null != endB.next) {
            count--;
            endB = endB.next;
        }

        // 2.比较两个链表的最后一个节点是不是相等
        // 两个链表不相交
        if (endA != endB) {
            return null;
        }

        // 3.两个链表相交，从头开始遍历，寻找相交的位置
        // 确定哪一个是长链表，哪一个是短链表
        ListNode listLong = count > 0 ? headA : headB;
        ListNode listShort = listLong == headA ? headB : headA;
        count = Math.abs(count);

        // 长链表的指针先走两个链表长度的差值步数
        while (count > 0) {
            count--;
            listLong = listLong.next;
        }

        // 从头遍历，寻找相交的位置
        while (listShort != listLong) {
            listShort = listShort.next;
            listLong = listLong.next;
        }

        return listLong;
    }
}