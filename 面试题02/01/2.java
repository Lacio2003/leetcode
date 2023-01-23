/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
    思路：
        1.遍历链表。
        2.使用循环从头到当前节点，来查看下一个节点是不是出现过。
    时间复杂度:O(N^2)
    空间复杂度:O(1)
*/
class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        // 排除不合法的情况
        if (null == head || null == head.next) {
            return head;
        }

        for (ListNode p = head; null != p.next;) {
            // 判断下一个节点是不是出现过
            ListNode is = head;
            // 利用循环从头开始开始检查
            while (p.next != is && is.val != p.next.val) {
                is = is.next;
            }

            if (is != p.next && is.val == p.next.val) {
                // 下一个节点是一个重复的节点
                p.next = p.next.next;
            } else {
                // 下一个节点不是重复的节点
                p = p.next;
            }
        }

        return head;
    }
}