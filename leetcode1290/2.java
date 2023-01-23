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
        1.遍历链表，如果当前数字是1，那么就对以前的和乘以2。(2进制如何转换为10进制)
        2.遍历完成即可。
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public int getDecimalValue(ListNode head) {
        int sum = head.val;
        for (ListNode p = head.next; null != p; p = p.next) {
            sum = (sum << 1) + p.val;
        }

        return sum;
    }
}