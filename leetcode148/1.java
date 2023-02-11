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
    将所有的结点的值放入到堆里面，然后根据堆创建链表。
    时间复杂度:O(nlogn)
    空间复杂度:O(n)
*/
class Solution {
    public ListNode sortList(ListNode head) {
        // 排除特殊情况
        if (null == head) {
            return null;
        }

        // 创建堆并将所有的元素放入到堆里面
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (ListNode p = head; null != p; p = p.next) {
            heap.add(p.val);
        }

        // 根据堆来创建链表
        ListNode newHead = new ListNode(0), cur = newHead;
        while (!heap.isEmpty()) {
            cur.next = new ListNode(heap.poll());
            cur = cur.next;
        }

        return newHead.next;
    }
}