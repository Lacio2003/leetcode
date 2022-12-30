/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    /**
     * Recursive implementation.
     */
    public void deleteNode(ListNode node) {
        // Assign the value of the next node to the current node.
        node.val = node.next.val;
        // The end condition for recursion.
        if (node.next.next == null) {
            node.next = null;
            return;
        }
        deleteNode(node.next);
    }
}