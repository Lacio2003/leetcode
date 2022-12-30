/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * Ideas:Use recursive traversal.Further improvements to recursive.
 * Time complexity:O(max(m, n))
 * Space complexity:O(n)
 */
class Solution {
    // The linked list of answers.
    ListNode ans = new ListNode();
    // Carray variables.
    int carry = 0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Recursive end conditions
        if (null == l1 && null == l2 && carry == 0) {
            return ans.next;
        }

        // Calculate the sum of the two ListNodes.
        int num1 = l1 != null ? l1.val : 0;
        int num2 = l2 != null ? l2.val : 0;
        int sum = num1 + num2 + carry;

        // Update carry.
        carry = sum / 10;
        sum %= 10;

        // Create a new node.
        return new ListNode(sum, addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next));
    }
}