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
 *   先遍历一遍链表，将所有的结点入栈。
 *   然后再遍历一遍链表，遇到一个结点出栈，进行对比。如果不相等则不是
 *   等到遍历完成，如果没有不相等的结点，这个链表就是回文链表
 * 时间复杂度:O(n)
 * 空间复杂度:O(n)
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // 栈
        Deque<Integer> stack = new ArrayDeque<>();

        // 将结点压入栈中
        for (ListNode p = head; p != null; p = p.next) {
            stack.push(p.val);
        }

        // 进行比对
        for (ListNode p = head; p != null; p = p.next) {
            if (p.val != stack.pop()) {
                // 结点不相等，说明不是回文链表
                return false;
            }
        }

        // 是回文链表
        return true;
    }
}