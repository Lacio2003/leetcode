/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * Ideas: Just solve it according to the topic.
 * Time complexity:O(n)
 * Space complexity:O(n)
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
            // The sum of the two numbers.
            // The carry situation needs to be considered.
            int sum = carryBit;
            // Regardless of whether it in or out, you must assign a value of 0, 
            // otherwise it will be limited to an infinite loop.
            carryBit = 0;

            // Calculate the sum of the two numbers according to different situations.
            if (first != null && second != null) {
                sum += first.val + second.val;
            } else if (first != null && second == null) {
                sum += first.val;
            } else if (first == null && second != null){
                sum += second.val;
            }

            // If the sum of the two numbers add up to more than 10, carry it.
            if (sum >= 10) {
                sum %= 10;
                carryBit = 1;
            }

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