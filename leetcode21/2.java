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
 *  1.递归的参数:newHead, list1, list2
 *  2.递归的返回值:void
 *  3.递归的结束条件:两个链表都为空的时候结束
 *  4.递归的流程:进行比较，如果有一个不为空，那么将的它值改为101,然后进行比较，链接小的
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode();
        mergeTwoListsRecursive(newHead, list1, list2);
        return newHead.next;
    }

    private void mergeTwoListsRecursive(ListNode newHead, ListNode list1, ListNode list2) {
        // 递归的结束条件
        if (null == list1 && null == list2) {
            return;
        }

        // 获取两个结点对应的值
        int first = null == list1 ? 101 : list1.val;
        int second = null == list2 ? 101 : list2.val;


        // 链接结点
        newHead.next = first <= second ? list1 : list2;

        // 移动list1和list2指针
        if (newHead.next == list1) {
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }
        mergeTwoListsRecursive(newHead.next, list1, list2);
    }
}