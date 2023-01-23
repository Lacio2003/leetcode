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
        1.遍历链表，使用一个栈将所有的结点压栈
        2.按照k的个数，对栈进行弹栈，返回对应的结点即可
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 1.准备一个栈，遍历链表，将所有的结点压栈
        Deque<ListNode> stack = new ArrayDeque<>();
        for (ListNode p = head; null != p; p = p.next) {
            stack.push(p);
        }
        
        // 2.按照k的值进行弹栈
        ListNode ans = null;
        for (int i = 1; i <= k; i++) {
            ans = stack.pop();
        }

        return ans;
    }
}