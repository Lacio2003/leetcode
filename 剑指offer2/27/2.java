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
 *   将回文串的后边部分压入栈。如何找到后半部分?使用快慢指针，一个是s，一个f，f指针每次都两步，s每次走一步，等到f走到结尾的时候，s指向的就是中间。
 *   从头开始，遍历链表，遇到一个结点，出栈进行比对，如果不相等则返回false。直到栈为空
 *   如果栈为空，没有不相等的结点，返回true
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // 寻找后半部分
        ListNode slow = head, fast = head;
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 将后半部分压入栈中
        Deque<Integer> stack = new ArrayDeque<>();
        while (null != slow) {
            stack.push(slow.val);
            slow = slow.next;
        }

        // 从头遍历
        for (ListNode p = head; !stack.isEmpty(); p = p.next) {
            if (p.val != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}