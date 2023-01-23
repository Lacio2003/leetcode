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
        1.准备两个指针，一个slow，一个是fast。
        2.fast指针先走k步，
        3.然后两个指针同时移动。最后fast指向空的时候，slow指向的节点就是所求节点
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 1.准备两个指针
        ListNode slow = head, fast = head;

        // 2.fast指针先走k步
        for (int i = 1; i <= k; i++) {
            fast = fast.next;
        }

        // 3.两个指针同时移动
        while (null != fast) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}