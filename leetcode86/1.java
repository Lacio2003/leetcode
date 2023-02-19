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
    使用双指针的思路

    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public ListNode partition(ListNode head, int x) {
        // 排除特殊情况
        if (null == head || null == head.next) {
            return head;
        }
        // 设置一个哑结点
        ListNode dummy = new ListNode();
        dummy.next = head;

        // 双指针遍历
        ListNode left = dummy, right = dummy;
        while (null != right.next) {
            // right.next.val < x
            if (right.next.val < x) {
                // 把这个结点拿出来
                ListNode cur = right.next;
                right.next = cur.next;

                // 插入到left的后面
                cur.next = left.next;
                left.next = cur;
                left = left.next;

                if (right.next == cur) {
                    // right和left重合，插入的是原来的位置
                    right = right.next;
                }
            } else {
                right = right.next;
            }
        }

        return dummy.next;
    }
}