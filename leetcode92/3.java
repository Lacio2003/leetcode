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
    website:https://leetcode.cn/problems/reverse-linked-list-ii/solutions/37247/bu-bu-chai-jie-ru-he-di-gui-di-fan-zhuan-lian-biao/
    思路:先找到反转的位置，然后利用反转前n个节点的递归进行反转
    时间复杂度:O(n)
    空间复杂度:O(n)
*/
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            // 当来到要反转的地方的时候，才进行反转
            return reversePervious(head, right);
        }

        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    ListNode succ = null;
    /**
     * 反转链表当中的前n个结点
     * @param head 要反转的链表的头结点
     * @param n 反转的结点的个数
     * @return 反转之后的链表的头结点
     */
    private ListNode reversePervious(ListNode head, int n) {
        if (n == 1) {
            succ = head.next;
            return head;
        }

        ListNode newNode = reversePervious(head.next, n - 1);
        head.next.next = head;
        head.next = succ;
        return newNode;
    }
}