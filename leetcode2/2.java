/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * Ideas: Just solve it according to the topic.Improvement on the basis of 1.
 * Time complexity:O(max(length))
 * Space complexity:O(1).Does not count as returning a linked list.
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Carray bit variable.
        int carryBit = 0;

        // The linked list after addition.
        // For ease of operation, add a head node.
        ListNode newNode = new ListNode(), p = newNode;

        // Iterate through the two linked list to achieve the addition operation.
        // First points the first linked list, second points the second linked list.
        // Pay attention to the condition at the end of the loop.
        for (ListNode first = l1, second = l2; first != null || second != null || carryBit != 0;) {
            
            // Calculate the sum of the two ListNode.
            int num1 = first != null ? first.val : 0;
            int num2 = second != null ? second.val : 0;
            int sum = num1 + num2 + carryBit;

            // Determine whether to carrry or not
            carryBit = sum / 10;
            sum %= 10;

            // Create a new node and fill in the data.
            p.next = new ListNode(sum);

            // Move the pointer.
            p = p.next;
            if (first != null) {
                first = first.next;
            }
            
            if (second != null) {
                second = second.next;
            }
        }

        return newNode.next;
    }
}