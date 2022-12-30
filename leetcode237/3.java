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
     * Time complexity:O(1)
     * Space complexity:O(1)
     */
    public void deleteNode(ListNode node) {
        // The next node.
        ListNode pre = node.next;
        // Assign the value of the next to the current node.
        node.val = pre.val;
        // Delete the next node.
        node.next = pre.next;
    }
}