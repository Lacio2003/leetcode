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
 * 思路：
 *   1.递归的参数:list1,list2
 *   2.递归的结束条件:两个指针都为空的时候
 *   3.递归的返回值:ListNode
 *   4.递归的流程:比较两个指针的大小，如果有一个指针为空，它的值为101。链接小的结点，并一定newHead指针
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 *
 */
class Solution {
    // 新的链表
    ListNode newHead = new ListNode(0);
    ListNode curNode = newHead;
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 递归的结束条件
        if (null == list1 && null == list2) {
            return newHead.next;
        }

        // 获取对应的结点的值
        int first = null == list1 ? 101 : list1.val;
        int second = null == list2 ? 101 : list2.val;

        // 链接结点
        curNode.next = first <= second ? list1 : list2;
        curNode = curNode.next;

        // 移动指针
        if (first <= second) {
            list1 = list1.next;
        } else {
            list2 = list2.next;
        }

        return mergeTwoLists(list1, list2);
    }
}