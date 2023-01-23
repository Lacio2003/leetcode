/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
    思路:
        1.递归的参数:head和k即可
        2.返回值：ListNode
        3.结束条件:null == head,并再这个时候对count = k.
        4.递归的流程:先递归到结束，然后对count，如果count等于0，直接结点。
        note:k是一个局部变量，传递参数的时候，值只在一个局部有效，所有需要声明一个和k等值的全局变量
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    int count = 0;
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 递归
        if (null == head) {
            count = k;
            return head;
        }
        ListNode ans = getKthFromEnd(head.next, k);
        count--;

        return count == 0 ? head : ans;
    }
}