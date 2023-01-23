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

/*
    思路:
        1.准备一个栈
        2.遍历链表，将所有的节点压入栈中
        3.遍历栈，将所有的节点出栈，进行累加
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public int getDecimalValue(ListNode head) {
        // 1.准备一个栈
        Deque<Integer> stack = new ArrayDeque<>();

        // 2.遍历链表，将所有的节点压入栈中
        for (ListNode p = head; null != p; p = p.next) {
            stack.push(p.val);
        }

        // 3.遍历栈，将所有的节点出栈，进行累加
        int sum = 0, count = 0;
        while (!stack.isEmpty()) {
            int curValue = stack.pop();
            sum += curValue * (int)Math.pow(2, count++);
        }

        return sum;
    }
}