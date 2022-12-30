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
     * Use two pointers to the current and the next node.Assigns the value of the next node to the current node. 
     * Finally, delte the last node.
     * Time complexity:O(n)
     * Space complexity:O(1)
     */
    public void deleteNode(ListNode node) {
        // The pre points to the current node.
        // The after points to the next node.
        ListNode pre = node, after = node.next;
        while (after.next != null) {
            // The next node is assigned to the current node.
            pre.val = after.val;
            // Move points.
            pre = after;
            after = after.next;
        }

        // The end has been reached.
        pre.val = after.val;
        // Delelte the last node.
        pre.next = null;
    }
}