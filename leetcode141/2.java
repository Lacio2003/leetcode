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

/**
 * 思路：
 *  1.准备一个快指针和一个慢指针。
 *  2.遍历链表，快指针一次走两步，慢指针一次走一步。如果有环，这两个指针一定可以相遇，返回true
 *  3.链表没有环，直接返回false。
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // 排除不合法的情况
        // 这里代码另一个目的是为了可以让快指针提前走两步
        if (null == head || null == head.next || null == head.next.next) {
            return false;
        }

        // 1.准备两个指针，一个快指针，一个慢指针
        // 为了方便处理，让快指针提前走两步
        ListNode slow = head, fast = head.next.next;
        while (null != fast.next && null != fast.next.next && slow != fast) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 2.看两个指针是不是相等
        // 相等就说明有环，不相等就是没有环
        return slow == fast;
    }
}