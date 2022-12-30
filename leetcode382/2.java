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
class Solution {
    // The linked list.
    ListNode head;
    // The length of the linked list.
    int length = 0;
    public Solution(ListNode head) {
        this.head = head;
        // Get the length of linked list.
        ListNode p = head;
        while (p != null) {
            length++;
            p = p.next;
        }
    }
    
    public int getRandom() {
        // A location is randomly gererated.
        Random random = new Random();
        int position = random.nextInt(length);
        // Get the current node.
        ListNode p = head;
        while (position --> 0) {
            p = p.next;
        }

        return p.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */