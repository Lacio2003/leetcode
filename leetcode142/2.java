/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
    思路:
        1.准备两个指针，一个是fast，一个slow
        2.fast每次走两步，slow每次走一步。
        3.如果两个指针可以相遇，那么说明有环，如果null == fast，说明没有环，直接返回null。
        4.如果有环，slow不动，fast从头开始，直接两个指针相遇，这个相遇的节点就是入环的第一个节点
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 排除不合法的情况
        if (null == head || null == head.next || null == head.next.next) {
            return null;
        }

        // 1.准备两个指针，一个是fast，一个slow
        // 为了方便，让和slow多走一步
        ListNode fast = head.next.next, slow = head.next;
        while (fast != slow) {
            if (null == fast.next || null == fast.next.next) {
                return null;
            }
            // fast一次走两步
            fast = fast.next.next;
            // slow一次走一步
            slow = slow.next;
        }

        // 程序可以执行到这里，说明有环        
        // 4.如果有环，slow不动，fast从头开始，直接两个指针相遇，这个相遇的节点就是入环的第一个节点
        fast = head;
        while (fast != slow)  {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}