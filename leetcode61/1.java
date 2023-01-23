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
        1.获取链表的长度
        2.将k和链表的长度进行比对
            如果k==链表的长度，链表保持不变
            如果k<链表的长度，将后k个节点移动到前面
            如果k>链表的长度，使用k%链表的长度，然后使用上面两个情况
    时间复杂度:O(n)
    空间复杂度:O(1)
*/
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // 排除不合法的情况
        if (null == head || null == head.next) {
            return head;
        }

        // 1.获取链表的长度
        int length = 0;
        for (ListNode p = head; null != p; p = p.next) {
            length++;
        }

        // 2.将k和链表的长度进行比对
        // 这一行代码是为了处理k>length的情况
        k %= length;
        return k == 0 ? head : moveNode(head, k);
    }

    /**
     * 将倒数k个节点放到链表的前面
     * @param head 原来链表的头部
     * @param k 数字k
     * @return 处理之后新链表的头部
     */
    private ListNode moveNode(ListNode head, int k) {
        // 获取倒数第k个节点
        ListNode slow = head, fast = head;
        // 这里提前走k-1，这样fast指向的位置就是尾巴节点了
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (null != fast.next) {
            fast = fast.next;
            slow = slow.next;
        }


        // 移动后k个节点
        fast.next = head;
        ListNode newHead = slow.next;
        slow.next = null;
        return newHead;
    }
}