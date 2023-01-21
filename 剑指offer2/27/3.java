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
 * 思路:
 *  1.先找链表的后半部分。怎么找?上一个解答里面有。
 *  2.反转中间以及后半部分。中间的结点的next变成空
 *  3.使用一个boolean变量is来记录是否是回文链表，默认为true
 *  4.使用两个指针，从两个头节点开始遍历，对比每一个结点。如果不相等，is=false，停止循环，将后半部分反转回去，返回is
 *  5.如果中间没有不相等的，最后将后半部分反转回去，返回is.
 * 时间复杂度:O(n)
 * 空间复杂度:O(1)
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // 1.寻找链表的中间
        ListNode slow = head, fast = head;
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 2.反转后半部分
        ListNode newNode = reverseList(slow);
        // 3.记录是否是回文串的变量
        boolean is = true;

        // 4.从两头开始遍历，进行对比
        for (ListNode p1 = head, p2 = newNode; null != p1 && null != p2; p1 = p1.next, p2 = p2.next) {
            if (p1.val != p2.val) {
                // 不是回文链表
                is = false;
                break;
            }
        }

        // 5.反转回去
        reverseList(newNode);

        return is;
    }

    /**
     * 反转链表
     * @param head 要反转的链表的头
     * @return 反转之后的链表的头部
     */
    private ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;
        while (null != cur) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}