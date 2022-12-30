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
  * Use random class to randomly generate subscripts.
  * Runtime complexity:O(n)
  * Space complexity:O(n);
  */
class Solution {
    // The numbers stores the nodes of the linked list.
    List<Integer> numbers = new ArrayList<>();
    public Solution(ListNode head) {
        // Stores the nodes inside the linked in numbers.
        ListNode p = head;
        while (p != null) {
            numbers.add(p.val);
            p = p.next;
        }
    }
    
    public int getRandom() {
        // Use random class to randomly generate subscripts.
        Random random = new Random();
        return numbers.get(random.nextInt(numbers.size()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */